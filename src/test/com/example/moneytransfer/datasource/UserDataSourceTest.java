package com.example.moneytransfer.datasource;

import com.example.moneytransfer.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDataSourceTest {

    @Test
    void when_NewUserAdded_Expect_ItShowedOnMap() {

        int initialUserCount = UserDataSource.getInstance().getAllUsers().size();
     
        UserDataSource.getInstance().addUser(new User(100));
     
        assertEquals(UserDataSource.getInstance().getAllUsers().size(), initialUserCount + 1,
                "When a new user is added, map size should be incremented by 1.");
    }

    @Test
    void when_GettingAllUsers_Expect_AListOfRegisteredUsers() {

        User addedUser = UserDataSource.getInstance().addUser(new User(100));

        User firstUser = UserDataSource.getInstance().getAllUsers().iterator().next();
        
        assertNotNull(firstUser, "A user should be on the list.");
        assertEquals(addedUser.balance(), firstUser.balance(), "User's cash amount should be correct.");
    }

    @Test
    void when_SearchedWithId_Expect_ReturnCorrectUser() {

        User user = new User(100);
        UserDataSource.getInstance().addUser(user);

        User userById = UserDataSource.getInstance().getUserById(user.getId());

        assertNotNull(userById, "User should fetched successfully.");
        assertEquals(user.getId(), userById.getId(), "ID's should be matched.");
        assertEquals(user.balance(), userById.balance(), "Balances should be matched.");
    }
}
