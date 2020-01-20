package com.car.rental.api.avis.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AvisAuth {
    private String accessToken;
    private String tokenType;
    private int expireIn;
}
