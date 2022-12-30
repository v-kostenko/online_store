package com.solvd.onlineStore.exceptions;


public class OrderCreationException extends Exception {

    public OrderCreationException() {
        super("Order creation exception");
    }

    public OrderCreationException(String message) {
        super(message);
    }
}
