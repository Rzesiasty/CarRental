package com.car.rental.facade;

import com.car.rental.domain.dto.BookingDto;
import com.car.rental.exceptions.BookingNotFoundException;
import com.car.rental.mapper.BookingMapper;
import com.car.rental.repository.BookingRepository;
import com.car.rental.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingFacade.class);

    @Autowired
    private BookingMapper mapper;

    @Autowired
    private BookingService service;

    @Autowired
    private BookingRepository repository;

    public List<BookingDto> getBookings() {
        LOGGER.info("Fetching all bookings from database");
        return mapper.mapToBookingDtoList(service.getAllBookings());
    }

    public BookingDto getBookingById(Long id) throws BookingNotFoundException {
        if (repository.findById(id).isPresent()) {
            LOGGER.info("Booking with id: " + id + " found.");
            return mapper.mapToBookingDto(service.getBooking(id));
        } else {
            LOGGER.error("There is no booking with id: " + id);
            throw new BookingNotFoundException();
        }
    }

    public void saveBooking(BookingDto booking) {
        service.saveBooking(mapper.mapToBooking(booking));
        LOGGER.info("Booking successful created.");
    }

    public BookingDto updateBooking(BookingDto bookingDto) throws BookingNotFoundException {
        if (repository.findById(bookingDto.getId()).isPresent()) {
            LOGGER.info("Booking with id: " + bookingDto.getId() + " found.");
            return mapper.mapToBookingDto(service.saveBooking(mapper.mapToBooking(bookingDto)));
        } else {
            LOGGER.error("There is no booking with id: " + bookingDto.getId());
            throw new BookingNotFoundException();
        }
    }

    public void deleteBooking(Long id) throws BookingNotFoundException {
        if (repository.findById(id).isPresent()) {
            service.deleteBooking(id);
            LOGGER.info("Booking with id " + id + " deleted.");
        } else {
            LOGGER.error("There is no booking with id: " + id);
            throw new BookingNotFoundException();
        }
    }
}
