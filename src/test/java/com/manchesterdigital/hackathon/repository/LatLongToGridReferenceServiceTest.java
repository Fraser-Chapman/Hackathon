package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.GridReference;
import com.manchesterdigital.hackathon.exceptions.WebApplicationException;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LatLongToGridReferenceServiceTest {

    private static final double LATITUDE = 1.0;
    private static final double LONGITUDE = 2.0;
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
        GridReference gridReference = new GridReference();
        gridReference.setGridRef("GridRef");
        ResponseEntity<GridReference> responseEntity = new ResponseEntity<>(gridReference, HttpStatus.OK);

        when(restTemplate.exchange(any(), any(), any(), eq(GridReference.class))).thenReturn(responseEntity);

        testSubject.getGridReferenceForLatLong(1.0, 2.0);

        verify(restTemplate).exchange(eq(uri),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(GridReference.class));
    }

    @Test
    public void shouldMapResponseToObjectCorrectly() {
        GridReference gridReference = new GridReference();
        gridReference.setGridRef("GridRef");
        ResponseEntity<GridReference> responseEntity = new ResponseEntity<>(gridReference, HttpStatus.OK);

        when(restTemplate.exchange(any(), any(), any(), eq(GridReference.class))).thenReturn(responseEntity);

        Assertions.assertThat(testSubject.getGridReferenceForLatLong(LATITUDE, LONGITUDE).getGridRef()).isEqualTo("GridRef");
    }

    @Test
    public void shouldThrowExceptionWhenRequestToPythonServiceUnsuccessful() {
        when(restTemplate.exchange(any(), any(), any(), eq(GridReference.class))).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        Assertions.assertThatExceptionOfType(WebApplicationException.class)
                .isThrownBy(() -> testSubject.getGridReferenceForLatLong(LATITUDE, LONGITUDE));
    }
}