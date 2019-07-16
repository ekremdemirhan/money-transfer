package com.example.moneytransfer.model;

import java.util.UUID;

public class User implements Lender, Receiver {

    private String id;

    private int cash;

    public User(int cash) {

        this.id = UUID.randomUUID().toString();
        this.cash = cash;
    }

    @Override
    public void sendMoney(int amount) {

        if(amount > cash) {
            throw new UserOutOfMoneyException("Lender does not have enough amount to make this transaction.");
        }
        cash = cash - amount;
    }

    @Override
    public void getMoney(int amount) {

        cash = cash + amount;
    }

    public String getId() {
        return id;
    }

    public int balance() {
        return cash;
    }
}
