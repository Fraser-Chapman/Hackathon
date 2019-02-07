package com.manchesterdigital.hackathon.service;

import com.manchesterdigital.hackathon.domain.ParkingData;
import com.manchesterdigital.hackathon.repository.CSVDocumentService;
import com.manchesterdigital.hackathon.repository.LatLongToGridReferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikelihoodService {

    CSVDocumentService csvDocumentService;
    LatLongToGridReferenceService latLongToGridReferenceService;

    public LikelihoodService(CSVDocumentService csvDocumentService, LatLongToGridReferenceService latLongToGridReferenceService) {
        this.csvDocumentService = csvDocumentService;
        this.latLongToGridReferenceService = latLongToGridReferenceService;
    }

    public double getLikelihood(double latitude, double longitude) {

        List<ParkingData> parkingData = csvDocumentService.getCarParkData();

        latLongToGridReferenceService.getGridreferenceForLatLong(latitude, longitude);


        return latitude + longitude + 0.5;
    }

}
