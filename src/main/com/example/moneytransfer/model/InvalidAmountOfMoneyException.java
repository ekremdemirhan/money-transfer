package com.example.moneytransfer.model;

public class InvalidAmountOfMoneyException extends RuntimeException {
    public InvalidAmountOfMoneyException(String s) {
        super(s);
    }
}
