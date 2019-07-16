package com.example.moneytransfer.integration;

import com.example.moneytransfer.application.UserManagement;
import com.example.moneytransfer.model.*;
import com.google.gson.Gson;

import static spark.Spark.*;

public class MoneyTransferController {

    public static void start() {

        post("/addUser", ((request, response) -> {
            Integer amount = new Gson().fromJson(request.body(), Amount.class).getAmount();
            User user = UserManagement.getInstance().addUserWithCashAmount(amount);
            return new Gson().toJson(user);
        }));

        get("/users", ((request, response) ->
                new Gson().toJsonTree(UserManagement.getInstance().getAllUsers())));

        get("/users/:id", ((request, response) ->
                new Gson().toJsonTree(UserManagement.getInstance().getUserById(request.params(":id")))));

        post("/users/:id/sendMoney/:receiverId", ((request, response) -> {
            Integer amount = new Gson().fromJson(request.body(), Amount.class).getAmount();
            Lender lenderUser = (Lender) UserManagement.getInstance().getUserById(request.params(":id"));
            Receiver receiverUser = (Receiver) UserManagement.getInstance().getUserById(request.params(":receiverId"));

            lenderUser.sendMoney(amount);
            receiverUser.getMoney(amount);

            return new Gson().toJsonTree(UserManagement.getInstance().getUserById(request.params(":id")));
        }));

        exception(UserOutOfMoneyException.class, (exception, request, response) -> response.body(new Gson().toJson(exception.getMessage())));

        exception(InvalidAmountOfMoneyException.class, (exception, request, response) -> response.body(new Gson().toJson(exception.getMessage())));
    }
}
