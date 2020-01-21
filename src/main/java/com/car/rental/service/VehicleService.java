package com.car.rental.service;

import com.car.rental.domain.Vehicle;
import com.car.rental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle getVehicle(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }

    public Vehicle saveVehicle(final Vehicle vehicle) {
        return repository.save(vehicle);
    }
}
