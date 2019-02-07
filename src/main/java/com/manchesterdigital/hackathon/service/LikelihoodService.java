package com.manchesterdigital.hackathon.service;

import org.springframework.stereotype.Service;

@Service
public class LikelihoodService {

    public double getLikelihood(double latitude, double longitude) {

        return latitude + longitude + 0.5;
    }

    private void convertLatLongToGridReference(double latitude, double longitude) {

    }
}
