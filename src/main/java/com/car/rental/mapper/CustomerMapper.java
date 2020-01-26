package com.car.rental.mapper;

import com.car.rental.domain.User;
import com.car.rental.domain.dto.UserDto;
import com.car.rental.encrypt.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    @Autowired
    private BookingMapper bookingMapper;

    public User mapToUser(final UserDto userDto) throws NoSuchProviderException, NoSuchAlgorithmException {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getEmail(),
                Encrypt.hashPassword(userDto.getPassword()),
                userDto.getStatus(),
                userDto.getKey(),
                bookingMapper.mapToBookingList(userDto.getBookings()));
    }

    public UserDto mapToUserNoPassDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getKey(),
                bookingMapper.mapToBookingDtoList(user.getBookings()));
    }
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getKey(),
                bookingMapper.mapToBookingDtoList(user.getBookings()));
    }

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getUserName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getStatus(),
                        user.getKey(),
                        bookingMapper.mapToBookingDtoList(user.getBookings())))
                .collect(Collectors.toList());
    }
}
