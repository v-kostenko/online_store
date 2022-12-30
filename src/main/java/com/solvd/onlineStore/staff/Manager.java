package com.solvd.onlineStore.staff;

import com.solvd.onlineStore.client.Address;
import com.solvd.onlineStore.client.IContact;
import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.util.Prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Manager extends Worker implements IContact, Prototype {
    private List<Employee> subordinates = new ArrayList<>();


    public Manager(String name, String surname, Date dateOfBirth, Gender gender, String citizenship,
                   String passport, long idNumber, String phone, String email, double salary, StaffId staffId,
                   Manager manager, Date employeeDate, double bonus) {
        super(name, surname, dateOfBirth, gender, citizenship, passport, idNumber, phone, email, salary, staffId,
                null, employeeDate, bonus);
    }

    public String showManagerInfo(){
        return "Name: " + getName() + "\nSurname: " + getSurname() + "\nPhone: " + getPhone() + "\ne-mail: " + getEmail()
                + "\n______________________________________________";
    }



    public Manager copy() {
        Prototype prototype  = () -> new Manager(this.getName(), this.getSurname(), this.getDateOfBirth(), this.getGender(),
                this.getCitizenship(), this.getPassport(), this.getIdNumber(), this.getPhone(), this.getEmail(),
                this.getSalary(), this.getStaffId().copy(), null, (Date) getEmploymentDate().clone(), getBonus());
        return (Manager) prototype;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nSurname: " + getSurname() + "\nPhone: " + getPhone() + "\nE-mail: " + getEmail() +
                "\nSalary: " + getSalary() + " y.e." + "\nBonus: " + getBonus() + " y.e." + "\nEmployment date: " + getEmploymentDate();
    }

    @Override
    public Address getAddress() {
        return null;
    }

    @Override
    public void setAddress(Address address) {
        throw new UnsupportedOperationException();
    }
}
