package com.solvd.onlineStore.exceptions;

public class ValidatorException extends Exception{

    public ValidatorException(){
        super("Incorrect entered data.");
    }

    public ValidatorException(String message){
        super(message);
    }


}
