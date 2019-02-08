package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.gridReference;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LatLongToGridReferenceServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private LatLongToGridReferenceService testSubject;

    @Before
    public void beforeEach() {
        testSubject = new LatLongToGridReferenceService(restTemplate);
    }

    @Test
    public void shouldCallPythonServiceThing() {
        URI uri = URI.create("http://localhost:5000?latitude=1.0&longitude=2.0");

        testSubject.getGridReferenceForLatLong(1.0, 2.0);

        verify(restTemplate).exchange(eq(uri),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(gridReference.class));
    }

    @Test
    public void shouldMapResponseToObjectCorrectly() {
        gridReference gridReference = new gridReference();
        gridReference.setGridRef("GridRef");
        ResponseEntity<com.manchesterdigital.hackathon.domain.gridReference> responseEntity = new ResponseEntity<>(gridReference, HttpStatus.OK);

        when(restTemplate.exchange(any(), any(), any(), eq(com.manchesterdigital.hackathon.domain.gridReference.class))).thenReturn(responseEntity);

        Assertions.assertThat(testSubject.getGridReferenceForLatLong(1.0, 2.0).getGridRef()).isEqualTo("GridRef");
    }

}