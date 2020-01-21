package com.car.rental.mapper;

import com.car.rental.domain.Booking;
import com.car.rental.domain.dto.BookingDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    public Booking mapToBooking(final BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                bookingDto.getCustomer(),
                bookingDto.getStatusCode(),
                bookingDto.getRegNumber(),
                bookingDto.getBookingFromDate(),
                bookingDto.getBookingToDate());
    }

    public BookingDto mapToBookingDto(final Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getCustomer(),
                booking.getStatusCode(),
                booking.getRegNumber(),
                booking.getBookingFromDate(),
                booking.getBookingToDate());
    }

    public List<BookingDto> mapToBookingDtoList(final List<Booking> bookingList) {
        return bookingList.stream()
                .map(b -> new BookingDto(b.getId(), b.getCustomer(), b.getStatusCode(),
                        b.getRegNumber(), b.getBookingFromDate(), b.getBookingToDate()))
                .collect(Collectors.toList());
    }

    public List<Booking> mapToBookingList(final List<BookingDto> bookingList) {
        return bookingList.stream()
                .map(b -> new Booking(b.getId(), b.getCustomer(), b.getStatusCode(),
                        b.getRegNumber(), b.getBookingFromDate(), b.getBookingToDate()))
                .collect(Collectors.toList());
    }
}
