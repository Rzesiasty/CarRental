package com.car.rental.facade;

import com.car.rental.domain.dto.VehicleDto;
import com.car.rental.exceptions.VehicleNotFoundException;
import com.car.rental.mapper.VehicleMapper;
import com.car.rental.repository.VehicleRepository;
import com.car.rental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleFacade.class);

    @Autowired
    private VehicleMapper mapper;

    @Autowired
    private VehicleService service;

    @Autowired
    private VehicleRepository repository;

    public List<VehicleDto> getAllVehicles() {
        LOGGER.info("Fetching all vehicles from database");
        return mapper.mapToVehicleDtoList(service.getAllVehicles());
    }

    public VehicleDto getVehicleById(Long id) throws VehicleNotFoundException {
        if (repository.findById(id).isPresent()) {
            LOGGER.info("Vehicle with id: " + id + " found.");
            return mapper.mapToVehicleDto(service.getVehicle(id));
        } else {
            LOGGER.error("There is no vehicle with id: " + id);
            throw new VehicleNotFoundException();
        }
    }

    public void saveVehicle(VehicleDto vehicleDto) {
        service.saveVehicle(mapper.mapToVehicle(vehicleDto));
        LOGGER.info("Vehicle successful created.");
    }

    public VehicleDto updateVehicle(VehicleDto vehicleDto) throws VehicleNotFoundException {
        if (repository.findById(vehicleDto.getCarId()).isPresent()) {
            LOGGER.info("Vehicle with id: " + vehicleDto.getCarId() + " found.");
            return mapper.mapToVehicleDto(service.saveVehicle(mapper.mapToVehicle(vehicleDto)));
        } else {
            LOGGER.error("There is no vehicle with id: " + vehicleDto.getCarId());
            throw new VehicleNotFoundException();
        }
    }

    public void deleteVehicle(Long id) throws VehicleNotFoundException {
        if (repository.findById(id).isPresent()) {
            service.deleteVehicle(id);
            LOGGER.info("Vehicle with id " + id + " deleted.");
        } else {
            LOGGER.error("There is no vehicle with id: " + id);
            throw new VehicleNotFoundException();
        }
    }


}
