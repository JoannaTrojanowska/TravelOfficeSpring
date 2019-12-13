package com.example.demo.model;

public class DomesticTrip extends Trip {


    int ownArrivalDiscount;

    public void setOwnArrivalDiscount(int ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    public DomesticTrip(String destination, MyDate start, MyDate end, int ownArrivalDiscount) {
        super(destination, start, end);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public int getPrice() {
        return super.getPrice()-ownArrivalDiscount;

    }
}
