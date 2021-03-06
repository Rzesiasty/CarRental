package com.car.rental.repository;

import com.car.rental.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    @Override
    List<Booking> findAll();

    @Override
    Optional<Booking> findById(Long id);

    @Override
    Booking save(Booking booking);

}
