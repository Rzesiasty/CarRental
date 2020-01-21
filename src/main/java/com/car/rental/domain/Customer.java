package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Long Id;

    @NotNull
    @Column(name = "CUSTOMER_FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "CUSTOMER_LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "customer",
            targetEntity = Address.class)
    private List<Address> addressList;

    @OneToMany(mappedBy = "customer",
            targetEntity = Booking.class)
    private Set<Booking> bookingSet;
}