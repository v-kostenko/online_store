package com.solvd.onlineStore.client;

public interface IContact {

    String getName();
    String getSurname();
    String getPhone();
    String getEmail();
    Address getAddress();

    void setPhone(String phone);
    void setEmail(String email);
    void setAddress(Address address);
}
