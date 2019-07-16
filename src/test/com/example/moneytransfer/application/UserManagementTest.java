package com.example.moneytransfer.application;

import com.example.moneytransfer.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserManagementTest {

    @Test
    void when_UserRegisteredWithValidCashAmount_Expect_ItSavedSuccessfully() {

        int cashAmount = 100;
        User user = UserManagement.getInstance().addUserWithCashAmount(cashAmount);

        assertNotNull(user, "User should be saved and returned successfully.");
        assertNotNull(user.getId(), "An ID should be assigned to user.");
        assertEquals(cashAmount, user.balance(), "User's balance should be set correctly.");
    }

    @Test
    void when_MoneyIsSent_Expect_UserMoneyBalanceUpdated() {

        User user = UserManagement.getInstance().addUserWithCashAmount(100);
        user.getMoney(100);

        User userById = UserManagement.getInstance().getUserById(user.getId());

        assertEquals(200, userById.balance(), "User's balance should be correct.");
    }

    @Test
    void when_RequestingListOfUsers_Expect_ListShouldBeReturnedSuccessfully() {

        User addedUser = UserManagement.getInstance().addUserWithCashAmount(100);

        User firstUser = UserManagement.getInstance().getAllUsers().iterator().next();

        assertNotNull(firstUser, "A user should be on the list.");
        assertEquals(addedUser.balance(), firstUser.balance(), "User's cash amount should be correct.");
    }

    @Test
    void when_GettingInfoForParticularUser_Expect_AllFieldsGottenSuccessfully() {

        User user = UserManagement.getInstance().addUserWithCashAmount(100);

        User userById = UserManagement.getInstance().getUserById(user.getId());

        assertNotNull(userById, "User should fetched successfully.");
        assertEquals(user.getId(), userById.getId(), "ID's should be matched.");
        assertEquals(user.balance(), userById.balance(), "Balances should be matched.");
    }
}