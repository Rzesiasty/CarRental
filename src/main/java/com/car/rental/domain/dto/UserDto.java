package com.car.rental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private int status;
    private Long key;
    private List<BookingDto> bookings;

    public UserDto(Long id, String userName, String email, int status, Long key, List<BookingDto> bookings) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.status = status;
        this.key = key;
        this.bookings = bookings;
    }
}
