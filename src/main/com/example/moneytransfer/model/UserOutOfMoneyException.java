package com.example.moneytransfer.model;

public class UserOutOfMoneyException extends RuntimeException {
    public UserOutOfMoneyException(String s) {
        super(s);
    }
}
