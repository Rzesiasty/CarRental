package com.car.rental.api.avis.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AvisConfig {

    @Value("${avis.api.endpoint.prod}")
    private String avisApiEndpoint;

    @Value("${avis.app.client.id}")
    private String avisAppClientId;

    @Value("${avis.app.client.secret}")
    private String avisAppClientSecret;

}
