package com.example.moneytransfer.model;

class InvalidAmountOfMoneyException extends RuntimeException {
    InvalidAmountOfMoneyException(String s) {
        super(s);
    }
}
