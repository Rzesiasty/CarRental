package com.car.rental.api.avis.client;

import com.car.rental.api.avis.auth.AvisAuthDto;
import com.car.rental.api.avis.config.AvisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
public class AvisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AvisClient.class);

    @Autowired
    private AvisConfig avisConfig;

    @Autowired
    private RestTemplate restTemplate;

    public URI buildURL() {
        return UriComponentsBuilder.fromHttpUrl(avisConfig.getAvisApiEndpoint() + "oauth/token/v1")
                .build().encode().toUri();
    }

//    private HttpHeaders createHttpHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.ALL));
//        headers.set("client_id", avisConfig.getAvisAppClientId());
//        headers.set("client_secret", avisConfig.getAvisAppClientSecret());
//        return headers;
//    }

    public List<AvisAuthDto> getAvisAuth() {
       // System.out.println(buildURL());
        try {
           // HttpEntity<String> entity = new HttpEntity<>(createHttpHeaders());
            AvisAuthDto[] authResponse = restTemplate.getForObject(buildURL(), AvisAuthDto[].class);
            return Arrays.asList(Optional.ofNullable(authResponse).orElse(new AvisAuthDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }

    }
}
