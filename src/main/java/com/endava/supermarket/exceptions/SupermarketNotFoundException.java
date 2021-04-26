package com.endava.supermarket.exceptions;

public class SupermarketNotFoundException extends RuntimeException{
    public SupermarketNotFoundException(String message) {
        super(message);
    }
}
