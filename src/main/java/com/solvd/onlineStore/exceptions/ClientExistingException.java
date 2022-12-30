package com.solvd.onlineStore.exceptions;

public class ClientExistingException extends Exception {

    public ClientExistingException(){
        super("Client with this email already exists.");
    }
    public ClientExistingException(String message) {
        super(message);

    }
}
