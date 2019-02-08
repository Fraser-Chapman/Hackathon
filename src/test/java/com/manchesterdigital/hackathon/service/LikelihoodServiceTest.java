package com.manchesterdigital.hackathon.service;

import com.manchesterdigital.hackathon.domain.gridReference;
import com.manchesterdigital.hackathon.domain.ParkingData;
import com.manchesterdigital.hackathon.repository.CSVDocumentService;
import com.manchesterdigital.hackathon.repository.LatLongToGridReferenceService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LikelihoodServiceTest {

    LikelihoodService testSubject;

    @Mock
    private LatLongToGridReferenceService latLongToGridReferenceService;

    @Mock
    private CSVDocumentService csvDocumentService;

    @Before
    public void beforeEach() {
        testSubject = new LikelihoodService(csvDocumentService, latLongToGridReferenceService);
    }

    @Test
    public void shouldCalculateLikelihood() {
        ParkingData parkingData = new ParkingData();
        parkingData.setGridRef("SD319361");
        parkingData.setAvgNumberOfTicketsPerDay("100");
        parkingData.setNumberOfTicketsIssued("1000");

        gridReference gridReference = new gridReference();
        gridReference.setGridRef("SD319361");

        when(csvDocumentService.getCarParkData())
                .thenReturn(Arrays.asList(parkingData));
        when(latLongToGridReferenceService.getGridReferenceForLatLong(1.0, 2.0)).thenReturn(gridReference);

        Assertions.assertThat(testSubject.getLikelihood(1.0, 2.0)).isEqualTo(10.0);
    }

}