package com.example.vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vehicles {
    private String carName;
    private String carBrand;
    private int carSold;
    private double price;
    private boolean isCarSport;

    public Vehicles(String carName, String carBrand, int carSold, double price, boolean isCarSport) {
        setCarName(carName);
        setCarBrand(carBrand);
        setCarSold(carSold);
        setPrice(price);
        setIsCarSport(isCarSport);
    }



    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {

        this.carName = carName;

    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        List<String> validCarBrand = Arrays.asList("Toyota","Honda","Benz","BMW");
        if (validCarBrand.contains(carBrand))
            this.carBrand = carBrand;
        else throw new IllegalArgumentException("Invalid car Brand");
    }

    public int getCarSold() {
        return carSold;
    }

    public void setCarSold(int carSold) {
        if (carSold >= 0)
        this.carSold = carSold;
        else throw new IllegalArgumentException("the number of car sold must be positive integers");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0)
        this.price = price;
        else throw new IllegalArgumentException("the price must be a positive number");
    }

    public boolean isCarSport() {
        return isCarSport;
    }

    public void setIsCarSport(boolean carSport) {
        isCarSport = carSport;
    }
}


