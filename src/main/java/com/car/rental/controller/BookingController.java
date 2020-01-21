package com.car.rental.controller;

import com.car.rental.domain.dto.BookingDto;
import com.car.rental.exceptions.BookingNotFoundException;
import com.car.rental.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "getBookings")
    public List<BookingDto> getBookings() {
        return facade.getBookings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookingById")
    public BookingDto getBookingById(@RequestParam Long id) throws BookingNotFoundException {
        return facade.getBookingById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBooking")
    public void deleteBooking(@RequestParam Long id) throws BookingNotFoundException {
        facade.deleteBooking(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBooking", consumes = APPLICATION_JSON_VALUE)
    public void saveBooking(@RequestBody BookingDto booking) {
        facade.saveBooking(booking);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBooking", consumes = APPLICATION_JSON_VALUE)
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto) throws BookingNotFoundException {
        return facade.updateBooking(bookingDto);
    }
}
