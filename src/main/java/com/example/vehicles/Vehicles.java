package com.example.vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vehicles {
    private int id;
    private String carName;
    private String carBrand;
    private int carSold;
    private double price;
    private boolean isCarSport;
    private int carSalesNumber;


    public Vehicles(String carName, String carBrand, int carSold, double price, boolean isCarSport) {
        setCarName(carName);
        setCarBrand(carBrand);
        setCarSold(carSold);
        setPrice(price);
        setIsCarSport(isCarSport);
        id=-1;
    }



    /**
     *  This is an "overloaded" constructor.
     *
     */
    public Vehicles(int id, String carName, String carBrand, int carSold, double price, boolean isCarSport) {
        this(carName,carBrand,carSold,price,isCarSport);
        setId(id);
    }

    public Vehicles(int id, String carName, String carBrand, int carSold, double price, boolean isCarSport, int carSalesNumber) {
        this(carName,carBrand,carSold,price,isCarSport);
        setId(id);
        setCarSalesNumber(carSalesNumber);
    }

    public Vehicles(int id, String carName, String carBrand, int carSold, double price, int carSalesNumber) {
        setCarName(carName);
        setCarBrand(carBrand);
        setCarSold(carSold);
        setPrice(price);
        setId(id);
        setCarSalesNumber(carSalesNumber);
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
        List<String> validCarBrand = getBrands();
        if (validCarBrand.contains(carBrand))
            this.carBrand = carBrand;
        else throw new IllegalArgumentException("Invalid car Brand. must be in the list of" + validCarBrand);
    }

    /**
     * return a list of valid car brands.
     * @return
     */
    public static List<String> getBrands() {
        List<String> brands = Arrays.asList("Toyota","Honda","Benz","BMW");
        //sort
        Collections.sort(brands);
        return brands;
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

    public boolean getisCarSport() {
        return isCarSport;
    }

    public void setIsCarSport(boolean carSport) {
        isCarSport = carSport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id<0) throw new IllegalArgumentException("id must be positive");
        else
        this.id = id;
    }

    public int getCarSalesNumber() {
        return carSalesNumber;
    }

    public void setCarSalesNumber(int carSalesNumber) {
        if (carSalesNumber >= 0)
        this.carSalesNumber = carSalesNumber;
        else
            throw new IllegalArgumentException("the number of sales must be a non-negative");
    }

    //toString method to make the output reasonable.
    @Override
    public String toString() {
        return String.format("%s-%s,sold %d, $%.1f, %s, %d",
                carBrand,carName,carSold,price,isCarSport,carSalesNumber);
    }

    public String getNameAndBrand()
    {
        return carName + "-" + carBrand;
    }
}


