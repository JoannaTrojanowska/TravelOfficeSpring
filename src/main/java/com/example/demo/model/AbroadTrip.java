package com.example.demo.model;

public class AbroadTrip extends Trip {


    public AbroadTrip(String destination, MyDate start, MyDate end, int insurance) {
        super(destination, start, end, 3567);
        this.insurance= insurance;
    }

    int insurance;

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    @Override
    public int getPrice() {
        return super.getPrice()+insurance;
    }


}
