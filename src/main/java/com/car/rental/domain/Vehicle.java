package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CAR_ID", unique = true)
    private Long carId;

    @NotNull
    @Column(name = "CAR_NAME", unique = true)
    private String carName;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    @OneToMany(mappedBy = "regNumber",
            targetEntity = Booking.class)
    private List<Booking> bookingList;
}
