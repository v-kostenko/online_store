package com.solvd.onlineStore.staff;

import com.solvd.onlineStore.client.Address;
import com.solvd.onlineStore.human.Gender;

import java.util.Date;

public final class Trainee extends Employee {
    private Date startPracticeDay;
    private long practiceLength;

    public Trainee(String name, String surname, Date dateOfBirth, Gender gender, String citizenship, String passport,
                   long idNumber, String phone, String email, double salary, StaffId staffId, Manager boss,
                   Date startPracticeDay, long practiceLength) {
        super(name, surname, dateOfBirth, gender, citizenship, passport, idNumber, phone, email, salary, staffId, boss);
        this.startPracticeDay = startPracticeDay;
        this.practiceLength = practiceLength;
    }

    public Date getStartPracticeDay() {
        return startPracticeDay;
    }

    public void setStartPracticeDay(Date startPracticeDay) {
        this.startPracticeDay = startPracticeDay;
    }

    public long getPracticeLength() {
        return practiceLength;
    }

    public void setPracticeLength(long practiceLength) {
        this.practiceLength = practiceLength;
    }

    @Override
    public String toString(){
        return super.toString() + "\nStart practice: " + startPracticeDay + "\nPractice length: " + practiceLength + " day(s)";
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
