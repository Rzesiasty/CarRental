package com.car.rental.domain.dto;

import com.car.rental.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private int zipCode;
    private Customer customer;
}
