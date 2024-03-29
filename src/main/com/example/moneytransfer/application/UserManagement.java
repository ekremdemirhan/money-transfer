package com.example.moneytransfer.application;

import com.example.moneytransfer.datasource.UserDataSource;
import com.example.moneytransfer.model.User;

import javax.sql.DataSource;
import java.util.Collection;

public class UserManagement {

    private static UserManagement ourInstance = new UserManagement();

    public static UserManagement getInstance() {
        return ourInstance;
    }

    private UserManagement() {

        runDataSource();
    }

    private void runDataSource() {

        UserDataSource.getInstance();
    }

    public User addUserWithCashAmount(int cashAmount) {

        User user = new User(cashAmount);
        return UserDataSource.getInstance().addUser(user);
    }

    public boolean updateUserBalance(User user) {

        User updatedUser = UserDataSource.getInstance().addUser(user);
        return updatedUser != null;

    }

    public Collection<User> getAllUsers() {

        return UserDataSource.getInstance().getAllUsers();
    }

    public User getUserById(String userId) {

        return UserDataSource.getInstance().getUserById(userId);
    }
}
