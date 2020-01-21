package com.car.rental.controller;

import com.car.rental.domain.dto.VehicleDto;
import com.car.rental.exceptions.VehicleNotFoundException;
import com.car.rental.facade.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/vehicle/")
public class VehicleController {

    @Autowired
    private VehicleFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "getVehicles")
    public List<VehicleDto> getVehicles() {
        return facade.getAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getVehicle")
    public VehicleDto getVehicle(@RequestParam Long id) throws VehicleNotFoundException {
        return facade.getVehicleById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteVehicle")
    public void deleteVehicle(@RequestParam Long id) throws VehicleNotFoundException {
        facade.deleteVehicle(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createVehicle", consumes = APPLICATION_JSON_VALUE)
    public void createVehicle(@RequestBody VehicleDto vehicleDto) {
        facade.saveVehicle(vehicleDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateVehicle", consumes = APPLICATION_JSON_VALUE)
    public VehicleDto updateVehicle(@RequestBody VehicleDto vehicleDto) throws VehicleNotFoundException {
        return facade.updateVehicle(vehicleDto);
    }
}
