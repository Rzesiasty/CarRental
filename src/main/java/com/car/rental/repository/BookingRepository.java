package com.car.rental.repository;

import com.car.rental.domain.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    @Override
    List<Booking> findAll();

    @Override
    Optional<Booking> findById(Long id);

    @Override
    Booking save(Booking booking);

    @Override
    void delete(Booking booking);
}
