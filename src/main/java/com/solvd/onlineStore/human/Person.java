package com.solvd.onlineStore.human;

import com.solvd.onlineStore.client.IContact;

import java.util.Date;

public abstract class Person extends Human implements IContact {
    private String citizenship;
    private String passport;
    private long idNumber;
    private String phone;
    private String email;

    public Person(String name, String surname, Date dateOfBirth, Gender gender, String citizenship, String passport,
                  long idNumber, String phone, String email) {
        super(name, surname, dateOfBirth, gender);
        this.citizenship = citizenship;
        this.passport = passport;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
    }

    public final String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public final String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public final long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hashcode = 7;
        hashcode = hashcode * 7 + Long.hashCode(idNumber);
        return hashcode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Person temp = (Person) object;
        return this.idNumber == temp.idNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCitizenship: " + citizenship + "\nPassport: " + passport + "\nid: " + idNumber
                + "\nPhone: " + phone + "\ne-mail: " + email;
    }
}