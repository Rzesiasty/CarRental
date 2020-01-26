package com.car.rental.service;

import com.car.rental.domain.User;
import com.car.rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<User> findAllCustomers(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

    public User saveCustomer(final User customer){
        return repository.save(customer);
    }
}
