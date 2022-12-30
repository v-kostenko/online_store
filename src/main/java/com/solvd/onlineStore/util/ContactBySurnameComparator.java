package com.solvd.onlineStore.util;

import com.solvd.onlineStore.client.IContact;

public class ContactBySurnameComparator implements IContactComparator{

    @Override
    public int compare(IContact o1, IContact o2){
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
