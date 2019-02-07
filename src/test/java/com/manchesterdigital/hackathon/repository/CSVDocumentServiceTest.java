package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.ParkingData;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVDocumentServiceTest {

    private CSVDocumentService testSubject;

    @Before
    public void beforeEach() {
        testSubject = new CSVDocumentService();
    }

    @Test
    public void shouldMapAllObjects() {
        List<ParkingData> parkingData = testSubject.getCarParkData();

        Assertions.assertThat(parkingData.size()).isEqualTo(1188);
        Assertions.assertThat(parkingData.get(0).getGridRef()).isEqualTo("SD319361");
        Assertions.assertThat(parkingData.get(0).getAvgNumberOfTicketsPerDay()).isEqualTo("0.005475702");
        Assertions.assertThat(parkingData.get(0).getNumberOfTicketsIssued()).isEqualTo("2");
    }

}