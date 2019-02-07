package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.GridReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Repository
public class LatLongToGridReferenceService {

    private final RestTemplate restTemplate = new RestTemplate();

    public GridReference getGridreferenceForLatLong(double latitude, double longitude) {
        URI uri = buildUri(latitude, longitude);

        try {
            HttpEntity<GridReference> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), GridReference.class);
            return response.getBody();
        }catch (Exception e) {

        }
        return null;
    }

    //TODO add real URL
    private URI buildUri(double latitude, double longitude) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString("http://localhost:8080/api/pythonystuff");

        uriComponentsBuilder.queryParams(getQueryParams(latitude, longitude));

        return uriComponentsBuilder.build().toUri();
    }

    private MultiValueMap<String, String> getQueryParams(double latitude, double longitude) {
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("latitude", latitude);
        params.add("longitude", longitude);

        return params;
    }

}
