package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
public class Customer {
    private long id;
    private String name;
    private Adress adress;
    private Trip trip;

    public Customer(long id, String name, Adress adress, Trip trip) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.trip = trip;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", trip=" + trip +
                '}';
    }


}
