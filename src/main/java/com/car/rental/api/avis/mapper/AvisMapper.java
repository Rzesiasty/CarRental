package com.car.rental.api.avis.mapper;

import com.car.rental.api.avis.auth.AvisAuth;
import com.car.rental.api.avis.auth.AvisAuthDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvisMapper {
    public List<AvisAuth> mapToAvisAuth(final List<AvisAuthDto> avisAuthDtos) {
        return avisAuthDtos.stream()
                .map(avisAuthDto ->
                        new AvisAuth(avisAuthDto.getAccessToken(), avisAuthDto.getTokenType(), avisAuthDto.getExpiresIn()))
                .collect(Collectors.toList());
    }

    public List<AvisAuthDto> mapToAvisListDto(final List<AvisAuth> avisAuths) {
        return avisAuths.stream()
                .map(avisAuth ->
                        new AvisAuthDto(avisAuth.getAccessToken(), avisAuth.getTokenType(), avisAuth.getExpireIn()))
                .collect(Collectors.toList());
    }
}
