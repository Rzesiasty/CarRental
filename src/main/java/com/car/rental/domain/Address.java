package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADDRESS")
public class Address {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADRESS_ID")
    private Long id;

    @NotNull
    @Column(name = "STREET_ADDRESS_1")
    private String streetAddress2;

    @Column(name = "STREET_ADDRESS_2")
    private String streetAddress1;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "ZIP_CODE")
    private int zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

}
