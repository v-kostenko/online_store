package com.solvd.onlineStore.client;

import com.solvd.onlineStore.util.Prototype;

import java.awt.*;

public class Address implements Prototype {
    private String city;
    private String street;
    private String houseNumber;

    public Address() {

    }

    public Address(String city, String street, String houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public Address copy(){
        Prototype prototype = () -> new Address(this.city, this.street, this.houseNumber);
        return (Address) prototype;
    }

    @Override
    public String toString() {
        return "-- " + getClass().getSimpleName() + " --\n" +
                "City: " + city + "\nStreet: " + street + "\nHouse number: " + houseNumber + "\n";
    }
}
