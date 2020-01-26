package com.car.rental.controller;

import com.car.rental.domain.dto.UserDto;
import com.car.rental.exceptions.CustomerNotFoundException;
import com.car.rental.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade facade;

    @RequestMapping(value = "saveCustomer", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody UserDto customerDto) throws NoSuchProviderException, NoSuchAlgorithmException {
        facade.createCustomer(customerDto);
    }

    @RequestMapping(value = "getCustomer", method = RequestMethod.GET)
    public UserDto getCustomer (@RequestParam Long id) throws CustomerNotFoundException {
        return facade.getCustomer(id);
    }

    @RequestMapping(value = "getCustomers", method = RequestMethod.GET)
    public List<UserDto> getCCustomers(){
        return facade.getCustomers();
    }

    @RequestMapping(value = "deleteCustomer", method = RequestMethod.DELETE)
    public void deleteCustomer(@RequestParam Long id) throws CustomerNotFoundException {
        facade.deleteCustomer(id);
    }

    @RequestMapping(value = "updateCustomer", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public UserDto updateCustomer(@RequestBody UserDto customerDto) throws CustomerNotFoundException, NoSuchProviderException, NoSuchAlgorithmException {
        return facade.updateCustomer(customerDto);
    }
}
