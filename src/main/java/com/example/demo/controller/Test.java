package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.TravelOffice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class Test {


    @Autowired
    TravelOffice travelOffice;

    @GetMapping("/customers")
    public Map<Long, Customer> getAllCustomers() {
        return travelOffice.getMapCustomer();
    }

    @GetMapping("/customerCount")
    public long customerCount() {
        return travelOffice.getCustomerCount();
    }

    @PostMapping("/POST")
    public Customer addCustomer(@RequestBody Customer customer) {
        travelOffice.addCustomer(customer);
        return customer;
    }



}