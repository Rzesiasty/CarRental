package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOKING_STATUS_CODE")
public class BookingStatusCode {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STATUS_ID")
    private Long statusId;

    @NotNull
    @Column(name = "STATUS_CODE")
    private String statusCode;

    @NotNull
    @Column(name = "STATUS_CODE_DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "statusCode")
    private List<Booking> bookingList;
}
