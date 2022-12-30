package com.solvd.onlineStore.reflection;

import java.util.Date;

public class Human {
    private String name;
    private Date dateOfBirth;
    private long id;

    public Human(){

    }

    public Human(String name, Date dateOfBirth, long id) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private void showInfo(){
        System.out.println("Hi! My name is " + name + ". I was born " + dateOfBirth);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
