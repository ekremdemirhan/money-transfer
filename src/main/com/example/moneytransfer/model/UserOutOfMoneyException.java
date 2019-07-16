package com.example.moneytransfer.model;

class UserOutOfMoneyException extends RuntimeException {
    UserOutOfMoneyException(String s) {
        super(s);
    }
}
