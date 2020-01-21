package com.car.rental.domain.dto;

import com.car.rental.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long carId;
    private String carName;
    private String description;
    private BigDecimal price;
    private List<Booking> bookingList;
}
