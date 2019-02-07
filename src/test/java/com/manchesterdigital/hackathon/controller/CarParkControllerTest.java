package com.manchesterdigital.hackathon.controller;

import com.manchesterdigital.hackathon.service.LikelihoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarParkControllerTest {

    @Mock
    LikelihoodService l;

    @Test
    public void shouldCallLikelihoodService(){
        CarParkController c = new CarParkController(l);
        c.getLikelihood(5.0,-5.0);
        verify(l).getLikelihood(5.0, -5.0);

    }
}