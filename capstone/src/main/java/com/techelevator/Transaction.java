package com.techelevator;

import java.math.BigDecimal;

public class Transaction {

    // Instance Variable
    private BigDecimal balance = new BigDecimal("0.00");

    // Method

    public void feedMoney(BigDecimal addedMoney) {
        balance = balance.add(addedMoney);
    }
}
