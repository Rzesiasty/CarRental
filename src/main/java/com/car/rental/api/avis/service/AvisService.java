package com.car.rental.api.avis.service;

import com.car.rental.api.avis.auth.AvisAuthDto;
import com.car.rental.api.avis.client.AvisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    @Autowired
    private AvisClient avisClient;

    public List<AvisAuthDto> fetchAvisAuth() {
        return avisClient.getAvisAuth();
    }
}
