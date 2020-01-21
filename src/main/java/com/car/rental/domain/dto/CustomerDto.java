package com.car.rental.domain.dto;

import com.car.rental.domain.Address;
import com.car.rental.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private List<Address> addressList;
    private Set<Booking> bookingSet;
}
