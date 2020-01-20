//package com.car.rental.api.avis.controller;
//
//import com.car.rental.api.avis.auth.AvisAuthDto;
//import com.car.rental.api.avis.client.AvisClient;
//import com.car.rental.api.avis.config.AvisConfig;
//import com.car.rental.api.avis.mapper.AvisMapper;
//import com.car.rental.api.avis.service.AvisService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.*;
//
//@CrossOrigin("*")
//@RestController
//public class AvisController {
//
//    private static final Logger LOG = LoggerFactory.getLogger(AvisController.class);
//
//    @Autowired
//    private AvisConfig avisConfig;
//
//    @Autowired
//    private AvisService avisService;
//
//    @Autowired
//    private AvisClient avisClient;
//
//    @Autowired
//    private AvisMapper avisMapper;
//
//
//    //    @RequestMapping(method = RequestMethod.GET, value = "getAvisToken")
////    public void getAvisToken(@RequestHeader HttpServletResponse headers) {
////        headers.setHeader("client_id", avisConfig.getAvisAppClientId());
////        headers.setHeader("client_secret", avisConfig.getAvisAppClientSecret());
////        avisClient.getAvisAuth();
////    }
//    @RequestMapping(method = RequestMethod.GET, value = "getAvisToken")
//    public List<AvisAuthDto> getAvisToken() throws JsonProcessingException, IOException {
//        ResponseEntity<AvisAuthDto[]> response = null;
//        LOG.info("Authorization Code------");
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        // According OAuth documentation we need to send the client id and secret key in the header for authentication
//        String credentials = "javainuse:secret";
//        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.set("client_id", avisConfig.getAvisAppClientId());
//        headers.set("client_secret", avisConfig.getAvisAppClientSecret());
//        //headers.add("Authorization", "Basic " + encodedCredentials);
//
//        HttpEntity<AvisAuthDto> request = new HttpEntity<>(headers);
////
////        String access_token_url = "https://stage.abgapiservices.com/oauth/token/v1";
////        access_token_url += "&grant_type=authorization_code";
////        access_token_url += "&redirect_uri=http://localhost:8080/getAvisToken";
//        try {
//            response = restTemplate.exchange(avisClient.buildURL(), HttpMethod.POST, request, AvisAuthDto[].class);
//
//            LOG.info("Access Token Response ---------" + response.getBody());
//            return Arrays.asList(Optional.ofNullable(response).orElse(new AvisAuthDto[0]))
//
//        } catch (
//                RestClientException e) {
//            LOG.error(e.getMessage(), e);
//            return new ArrayList<>();
//        }
//    }
//
//    @RequestMapping(value = "listHeaders", method = RequestMethod.GET)
//    public ResponseEntity<String> listAllHeaders(
//            @RequestHeader Map<String, String> headers) {
//        headers.forEach((key, value) -> {
//            LOG.info(String.format("Header '%s' = %s", key, value));
//        });
//
//        return new ResponseEntity<String>(
//                String.format("Listed %d headers", headers.size()), HttpStatus.OK);
//    }
//}
