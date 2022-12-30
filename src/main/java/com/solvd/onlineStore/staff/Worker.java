package com.solvd.onlineStore.staff;

import com.solvd.onlineStore.client.Address;
import com.solvd.onlineStore.human.Gender;

import java.util.Date;

public class Worker extends Employee{

    private Date employmentDate;
    private double bonus;

    public Worker(String name, String surname, Date dateOfBirth, Gender gender, String citizenship, String passport, long idNumber,
                  String phone, String email, double salary, StaffId staffId, Manager boss, Date employmentDate, double bonus) {
        super(name, surname, dateOfBirth, gender, citizenship, passport, idNumber, phone, email, salary, staffId, boss);
        this.employmentDate = employmentDate;
        this.bonus = bonus;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public Address getAddress(){
        return null;
    }

    @Override
    public void setAddress(Address address){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        return "----- " + getClass().getSimpleName() + " -----\nName: " + getName() + "\nSurname: " + getSurname() + "\nPhone: " + getPhone() +
                "\nEmail: " + getEmail() + "\nSalary: " + getSalary() + " y.e." + "\nBonus: " + bonus +  " y.e." +
                "\n```` Manager: ````\n" + getBoss();
    }
}
