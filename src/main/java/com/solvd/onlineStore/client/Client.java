package com.solvd.onlineStore.client;

import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.human.Person;
import com.solvd.onlineStore.util.Prototype;

import java.util.Date;

public final class Client extends Person implements Prototype, IContact {
    private Address address;

    public Client(String name, String surname, Date dateOfBirth, Gender gender, String citizenship,
                  String passport, long idNumber, String phone, String email, Address address) {
        super(name, surname, dateOfBirth, gender, citizenship, passport, idNumber, phone, email);
        this.address = address;
    }

    public String showClientInfo(){
        return "\nName: " +  getName() + "\nSurname: " + getSurname() + "\nPhone: " + getPhone() +
              "\ne-mail: " + getEmail()  + "\n" + getAddress();
    }

    @Override
    public Address getAddress(){
        return this.address;
    }

    @Override
    public void setAddress(Address address){
        this.address = address;
    }

    @Override
    public Client copy(){
        Prototype prototype = () -> new Client(this.getName(), this.getSurname(), this.getDateOfBirth(), this.getGender(),
                this.getCitizenship(), this.getPassport(), this.getIdNumber(), this.getPhone(), this.getEmail(),
                this.address.copy());

        return (Client) prototype;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAddress: " + address;
    }


}
