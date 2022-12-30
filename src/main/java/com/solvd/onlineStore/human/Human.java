package com.solvd.onlineStore.human;

import java.util.Date;

public abstract class Human {
    private String name;
    private String surname;
    private final Date dateOfBirth;
    private final Gender gender;


    public Human(String name, String surname, Date dateOfBirth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public final Date getDateOfBirth() {
        return dateOfBirth;
    }

    public final Gender getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "\nName: " + name + "\nSurname: " + surname + "\nDate of birth: " + dateOfBirth + "\nGender: " + gender;
    }

}
