package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "BOOKING_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_BOOKING")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_CODE")
    private BookingStatusCode statusCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_NUMBER")
    private Vehicle regNumber;

    @NotNull
    @Column(name = "BOOKING_FROM_DATE")
    private LocalDate bookingFromDate;

    @NotNull
    @Column(name = "BOOKING_TO_DATE")
    private LocalDate bookingToDate;
}
