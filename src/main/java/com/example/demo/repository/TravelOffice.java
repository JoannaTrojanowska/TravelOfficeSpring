package com.example.demo.repository;

import com.example.demo.exception.MyException;
import com.example.demo.model.Adress;
import com.example.demo.model.Customer;
import com.example.demo.model.MyDate;
import com.example.demo.model.Trip;
import lombok.Data;


import org.springframework.stereotype.Repository;

import java.util.*;

@Data
@Repository
public class TravelOffice {


    public Map<Long, Customer> mapCustomer = new HashMap<>();

    {
        MyDate start = new MyDate(2019, 11, 7);
        MyDate end = new MyDate(2019, 11, 14);
        Adress adress = new Adress("Piotrkowska 76", "90-650", "Lodz");
        Adress adress1 = new Adress("Radwańska 27", "99-908", "Lodz");
        Trip trip = new Trip("Tajlandia", start, end, 2345);
        Trip trip1 = new Trip("Wietnam", start, end, 5666);
        Customer customer1 = new Customer(1, "Michał Kowalski", adress, trip);
        Customer customer2 = new Customer(2, "Adam Nowak", adress1, trip1);
        Customer customer3 = new Customer(3, "Anna Kulesza", adress1, trip);
        Customer customer4 = new Customer(4, "Weronika Adamczyk", adress, trip1);
        mapCustomer.put((long) 1, customer1);
        mapCustomer.put((long) 2, customer2);
        mapCustomer.put((long) 3, customer3);
        mapCustomer.put((long) 4, customer4);
    }


    public Map<Long, Customer> getMapCustomer() {

        return mapCustomer;
    }

    public long getCustomerCount() {

        return mapCustomer.size();
    }


    public void addCustomer(Customer customer) {
        mapCustomer.put(customer.getId(), customer);
      //  throw new MyException();
    }


}
