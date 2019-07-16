package com.example.moneytransfer.model;

import com.example.moneytransfer.application.UserManagement;

import java.util.UUID;

public class User implements Lender, Receiver {

    private String id;

    private int cash;

    public User(int cash) {

        if(cash < 0) {
            throw new InvalidAmountOfMoneyException("The cash amount is not valid. Add more money than 0.");
        }
        this.id = UUID.randomUUID().toString();
        this.cash = cash;
    }

    @Override
    public void sendMoney(int amount) {

        if(amount > cash) {
            throw new UserOutOfMoneyException("Lender does not have enough amount to make this transaction.");
        }
        cash = cash - amount;

        UserManagement.getInstance().updateUserBalance(this);
    }

    @Override
    public void getMoney(int amount) {

        cash = cash + amount;

        UserManagement.getInstance().updateUserBalance(this);
    }

    public String getId() {
        return id;
    }

    public int balance() {
        return cash;
    }
}
