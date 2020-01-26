package com.car.rental.mapper;

import com.car.rental.domain.Booking;
import com.car.rental.domain.dto.BookingDto;
import com.car.rental.service.CustomerService;
import com.car.rental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    public Booking mapToBooking(final BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                customerService.findById(bookingDto.getUser()),
                vehicleService.getVehicle(bookingDto.getVehicle()),
                bookingDto.getBookingFromDate(),
                bookingDto.getBookingToDate());
    }

    public BookingDto mapToBookingDto(final Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getUser().getId(),
                booking.getVehicle().getCarId(),
                booking.getBookingFromDate(),
                booking.getBookingToDate());
    }

    public List<BookingDto> mapToBookingDtoList(final List<Booking> bookingList) {
        if (bookingList != null) {
            return bookingList.stream()
                    .map(booking -> new BookingDto(
                            booking.getId(),
                            booking.getUser().getId(),
                            booking.getVehicle().getCarId(),
                            booking.getBookingFromDate(),
                            booking.getBookingToDate()))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Booking> mapToBookingList(final List<BookingDto> bookingList) {
        if (bookingList != null) {
            return bookingList.stream()
                    .map(bookingDto -> new Booking(
                            bookingDto.getId(),
                            customerService.findById(bookingDto.getUser()),
                            vehicleService.getVehicle(bookingDto.getVehicle()),
                            bookingDto.getBookingFromDate(),
                            bookingDto.getBookingToDate()))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
