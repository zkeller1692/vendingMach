package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    // Instance Variable
    private BigDecimal balance = new BigDecimal("0.00");
    private List<Item> itemsToBuy = new ArrayList<>();

    // Getters

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Item> getItemsToBuy() {
        return itemsToBuy;
    }

    // Method

    public void feedMoney(String moneyToFeed) {
        BigDecimal addedMoney = new BigDecimal(moneyToFeed);
        balance = balance.add(addedMoney);
    }

    public void addItem(Item itemToBuy){
        // TODO -- Fix compare BigDecimal
        if (balance > 0 && balance >= itemToBuy.getItemPrice())
        itemsToBuy.add(itemToBuy);
    }
}
