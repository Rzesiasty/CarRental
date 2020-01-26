package com.car.rental.facade;

import com.car.rental.domain.dto.UserDto;
import com.car.rental.exceptions.CustomerNotFoundException;
import com.car.rental.mapper.CustomerMapper;
import com.car.rental.repository.CustomerRepository;
import com.car.rental.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

@Component
public class CustomerFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleFacade.class);

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    public void createCustomer(UserDto userDto) throws NoSuchProviderException, NoSuchAlgorithmException {
        service.saveCustomer(mapper.mapToUser(userDto));
        LOGGER.info("User successful created.");

    }

    public UserDto getCustomer(Long id) throws CustomerNotFoundException {
        if (repository.findById(id).isPresent()) {
            LOGGER.info("User with id: " + id + " found.");
            return mapper.mapToUserNoPassDto(service.findById(id));
        } else {
            LOGGER.error("There is no user with id: " + id);
            throw new CustomerNotFoundException();
        }
    }

    public List<UserDto> getCustomers() {
        LOGGER.info("Fetching all users from database");
        return mapper.mapToUserDtoList(service.findAllCustomers());
    }

    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        if (repository.findById(id).isPresent()) {
            service.deleteCustomer(id);
            LOGGER.info("User with id " + id + " deleted.");
        } else {
            LOGGER.error("There is no user with id: " + id);
            throw new CustomerNotFoundException();
        }
    }

    public UserDto updateCustomer(UserDto userDto) throws CustomerNotFoundException, NoSuchProviderException, NoSuchAlgorithmException {
        if (repository.findById(userDto.getId()).isPresent()) {
            LOGGER.info("User with id: " + userDto.getId() + " found.");
            return mapper.mapToUserDto(service.saveCustomer(mapper.mapToUser(userDto)));
        } else {
            LOGGER.error("There is no user with id: " + userDto.getId());
            throw new CustomerNotFoundException();
        }
    }
}