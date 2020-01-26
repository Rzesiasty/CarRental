package com.car.rental.mapper;

import com.car.rental.domain.Vehicle;
import com.car.rental.domain.dto.VehicleDto;
import com.car.rental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {

    @Autowired
    private BookingMapper bookingMapper;

    public Vehicle mapToVehicle(final VehicleDto vehicleDto) {
        return new Vehicle(
                vehicleDto.getCarId(),
                vehicleDto.getCarName(),
                vehicleDto.getDescription(),
                vehicleDto.getPrice(),
                bookingMapper.mapToBookingList(vehicleDto.getBookingList()));
    }

    public VehicleDto mapToVehicleDto(final Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getCarId(),
                vehicle.getCarName(),
                vehicle.getDescription(),
                vehicle.getPrice(),
                bookingMapper.mapToBookingDtoList(vehicle.getBookings()));
    }

    public List<VehicleDto> mapToVehicleDtoList(final List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(vehicle -> new VehicleDto(
                        vehicle.getCarId(),
                        vehicle.getCarName(),
                        vehicle.getDescription(),
                        vehicle.getPrice(),
                        bookingMapper.mapToBookingDtoList(vehicle.getBookings())))
                .collect(Collectors.toList());
    }
}
