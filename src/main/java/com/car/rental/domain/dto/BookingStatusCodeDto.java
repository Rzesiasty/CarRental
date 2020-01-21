package com.car.rental.domain.dto;

import com.car.rental.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingStatusCodeDto {
    private Long statusId;
    private String statusCode;
    private String description;
    private List<Booking> bookingList;
}
