package com.solvd.onlineStore.exceptions;

public class AgeException extends Exception{

    public AgeException(){
        super("not 18 years");
    }

    public AgeException(String message){
        super(message);
    }
}
