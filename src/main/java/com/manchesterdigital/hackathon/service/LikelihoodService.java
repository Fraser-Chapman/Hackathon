package com.manchesterdigital.hackathon.service;

import com.manchesterdigital.hackathon.domain.GridReference;
import com.manchesterdigital.hackathon.domain.ParkingData;
import com.manchesterdigital.hackathon.exceptions.GridReferenceLookupException;
import com.manchesterdigital.hackathon.exceptions.WebApplicationException;
import com.manchesterdigital.hackathon.repository.CSVDocumentService;
import com.manchesterdigital.hackathon.repository.LatLongToGridReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class LikelihoodService {

    CSVDocumentService csvDocumentService;
    LatLongToGridReferenceService latLongToGridReferenceService;

    @Autowired
    public LikelihoodService(CSVDocumentService csvDocumentService, LatLongToGridReferenceService latLongToGridReferenceService) {
        this.csvDocumentService = csvDocumentService;
        this.latLongToGridReferenceService = latLongToGridReferenceService;
    }

    public double getLikelihood(double latitude, double longitude) {

        List<ParkingData> parkingData = csvDocumentService.getCarParkData();

        GridReference gridReference = latLongToGridReferenceService.getGridReferenceForLatLong(latitude, longitude);

        try {
            for (ParkingData value: parkingData ) {

                if(value.getGridRef().equals(gridReference.getGridRef())){
                    return toTwoDecimalPlaces((Double.parseDouble(value.getAvgNumberOfTicketsPerDay())/
                            Double.parseDouble(value.getNumberOfTicketsIssued()))*100);
                }

            }

            throw new GridReferenceLookupException("Could not find corresponding grid reference for location");

        } catch (GridReferenceLookupException gridRefException) {
            throw new WebApplicationException(400, gridRefException.getMessage());
        }

    }

    private double toTwoDecimalPlaces(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(value));
    }

}
