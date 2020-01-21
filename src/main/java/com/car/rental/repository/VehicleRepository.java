package com.car.rental.repository;

import com.car.rental.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    @Override
    List<Vehicle> findAll();

    @Override
    Optional<Vehicle> findById(Long id);

    @Override
    void deleteById(Long id);
}
