package com.example.moneytransfer;

import com.example.moneytransfer.application.UserManagement;
import com.example.moneytransfer.integration.MoneyTransferController;

public class MoneyTransfer {

    public static void main(String[] args) {

        initDataManagement();
        initApp();
    }

    private static void initDataManagement() {

        UserManagement.getInstance();
    }

    private static void initApp() {

        MoneyTransferController.start();
    }
}
