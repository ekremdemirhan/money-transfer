package com.example.moneytransfer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void when_UserSendMoney_Expect_UpdateUserBalanceCorrectly() {

        int amount = 100;
        int initialBalance = 1000;
        User user = new User(initialBalance);

        user.sendMoney(amount);

        assertEquals(initialBalance - amount, user.balance(), "When user send money, balance should be correct.");

    }

    @Test
    void when_UserReceiveMoney_Expect_UpdateUserBalanceCorrectly() {

        int amount = 100;
        int initialBalance = 0;
        User user = new User(initialBalance);

        user.getMoney(amount);

        assertEquals(initialBalance + amount, user.balance(), "When user get money, balance should be correct.");
    }

    @Test
    void when_IdRequested_Expect_ReturnIdCorrectly() {

        User user = new User(0);

        assertNotNull(user.getId(), "ID should be set for a new user.");
    }

    @Test
    void when_BalanceRequest_ExpectReturnBalanceCorrectly() {

        int cashBalance = 100;
        User user = new User(cashBalance);

        assertEquals(cashBalance, user.balance(), "Balance should be got correctly.");
    }
}