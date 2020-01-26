package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CUSTOMER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "MAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "USER_KEY")
    private Long key;

    @OneToMany(mappedBy = "user",
            targetEntity = Booking.class)
    private List<Booking> bookings = new ArrayList<>();
}