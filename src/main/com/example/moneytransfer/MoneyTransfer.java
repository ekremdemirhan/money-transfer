package com.example.moneytransfer;

import spark.Spark;

public class MoneyTransfer {

    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> "Hellooooo!");
    }
}
