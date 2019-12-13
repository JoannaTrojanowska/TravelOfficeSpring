package com.example.demo.model;



public class Trip {
    private String destination;
    private MyDate start;
    private MyDate end;
    private int price;

    public Trip(String destination, MyDate start, MyDate end, int price) {
        this.destination = destination;
        this.start = start;
        this.end = end;
        this.price = price;
    }


    public Trip(String destination, MyDate start, MyDate end) {
    }

    @Override
    public String toString() {
        return "Trip{" +
                "destination='" + destination + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", price=" + price +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public MyDate getStart() {
        return start;
    }

    public void setStart(MyDate start) {
        this.start = start;
    }

    public MyDate getEnd() {
        return end;
    }

    public void setEnd(MyDate end) {
        this.end = end;
    }
}


