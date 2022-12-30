package com.solvd.onlineStore.exceptions;

public class EmptyCartException extends Exception{

    public EmptyCartException(){
        super("Cart is empty");
    }

    public EmptyCartException(String message){
        super(message);
    }
}
