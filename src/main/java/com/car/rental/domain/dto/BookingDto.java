package com.car.rental.domain.dto;

import com.car.rental.domain.BookingStatusCode;
import com.car.rental.domain.Customer;
import com.car.rental.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;
    private Customer customer;
    private BookingStatusCode statusCode;
    private Vehicle regNumber;
    private LocalDate bookingFromDate;
    private LocalDate bookingToDate;

}
