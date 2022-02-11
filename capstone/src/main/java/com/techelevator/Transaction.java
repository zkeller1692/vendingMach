package com.techelevator;

import java.math.BigDecimal;

public class Transaction {

    // Instance Variable
    private BigDecimal balance = new BigDecimal("0.00");

    // Getters

    public BigDecimal getBalance() {
        return balance;
    }


    // Method

    public void feedMoney(String moneyToFeed) {
        BigDecimal addedMoney = new BigDecimal(moneyToFeed);
        balance = balance.add(addedMoney);
    }
}
