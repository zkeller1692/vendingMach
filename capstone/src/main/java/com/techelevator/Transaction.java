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
        //TODO -- High priority for testing
        BigDecimal itemPrice = itemToBuy.getItemPrice();
        if (balance.compareTo(BigDecimal.ZERO) > 0 && !(itemPrice.compareTo(balance) > 0)) {
            itemsToBuy.add(itemToBuy);
            balance = balance.subtract(itemPrice);
        } else {
            System.out.println("Insufficient funds. Please add money.");
        }
    }
}
