package com.car.rental.controller;

import com.car.rental.domain.dto.BookingDto;
import com.car.rental.mapper.BookingMapper;
import com.car.rental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingMapper mapper;

    @Autowired
    private BookingService service;

    @RequestMapping(method = RequestMethod.GET, value = "getBookings")
    public List<BookingDto> getBookings() {
        return mapper.mapToBookingDtoList(service.getAllBookings());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookingById")
    public BookingDto getBookingById(@RequestParam Long id) {
        return mapper.mapToBookingDto(service.getBookingById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBooking", consumes = APPLICATION_JSON_VALUE)
    public void saveBooking(@RequestBody BookingDto booking) {
        service.saveBooking(mapper.mapToBooking(booking));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBooking", consumes = APPLICATION_JSON_VALUE)
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto){
        return mapper.mapToBookingDto(service.saveBooking(mapper.mapToBooking(bookingDto)));
    }
}
