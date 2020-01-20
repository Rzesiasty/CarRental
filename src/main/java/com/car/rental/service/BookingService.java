package com.car.rental.service;

import com.car.rental.domain.Booking;
import com.car.rental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Booking saveBooking(final Booking booking) {
        return repository.save(booking);
    }

    public void deleteBooking(final Booking booking) {
        repository.delete(booking);
    }
}
