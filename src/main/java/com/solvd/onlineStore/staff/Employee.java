package com.solvd.onlineStore.staff;

import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.human.Person;

import java.util.Date;

public abstract class Employee extends Person {
    private double salary;
    private StaffId staffId;
    private Manager boss;

    public Employee(String name, String surname, Date dateOfBirth, Gender gender, String citizenship, String passport,
                    long idNumber, String phone, String email, double salary, StaffId staffId, Manager boss) {
        super(name, surname, dateOfBirth, gender, citizenship, passport, idNumber, phone, email);
        this.salary = salary;
        this.staffId = staffId;
        this.boss = boss;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public StaffId getStaffId() {
        return staffId;
    }

    public void setStaffId(StaffId staffId) {
        this.staffId = staffId;
    }

    public Manager getBoss() {
        return boss;
    }

    public void setBoss(Manager boss) {
        this.boss = boss;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": \nName: " + getName() + "\nSurname: " + getSurname() +
                 "\nSalary: " + salary + " y.e.";
    }



}
