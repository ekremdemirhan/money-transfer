package com.example.moneytransfer.datasource;

import com.example.moneytransfer.model.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataSource {

    private static UserDataSource ourInstance = new UserDataSource();
    private ConcurrentHashMap<String, User> userMap;

    public static UserDataSource getInstance() {
        return ourInstance;
    }

    private UserDataSource() {

        start();
    }

    private void start() {

        userMap = new ConcurrentHashMap<>();
    }

    public User addUser(User user) {

        userMap.put(user.getId(), user);
        return user;
    }

    public Collection<User> getAllUsers() {

        return userMap.values();
    }

    public User getUserById(String userId) {

        return userMap.get(userId);
    }
}
