package com.techelevator;

import com.techelevator.currency.Coins;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    // Instance Variable
    private BigDecimal balance = new BigDecimal("0.00");
    //private List<Item> itemsToBuy = new ArrayList<>();

    // Getters

    public BigDecimal getBalance() {
        return balance;
    }

    /*
    public List<Item> getItemsToBuy() {
        return itemsToBuy;
    }
     */

    // Method

    public void feedMoney(String moneyToFeed) {
        BigDecimal addedMoney = new BigDecimal(moneyToFeed);
        balance = balance.add(addedMoney);
    }

    public void buyItem(Item itemToBuy){
        //TODO -- High priority for testing
        BigDecimal itemPrice = itemToBuy.getItemPrice();
        boolean sufficientFunds = balance.compareTo(BigDecimal.ZERO) > 0 && !(itemPrice.compareTo(balance) > 0);
        boolean itemInStock = itemToBuy.getItemStock() > 0;
        if (sufficientFunds && itemInStock) {
            balance = balance.subtract(itemPrice);
            //itemsToBuy.add(itemToBuy);
            itemToBuy.removeItemFromStock();
            System.out.println(itemToBuy);
            itemToBuy.printPurchaseMessage();
        } else if (!sufficientFunds) {
            System.out.println("Insufficient funds. Please add money.");
        } else {
            System.out.println("SOLD OUT");
        }
    }

    // TODO -- High Priority for Testing
    public void returnChange(){
        System.out.println("\nChange Returned: ");
        for (Coins coin : Coins.VALID_COINS){
            BigDecimal coinAsBigDecimal = new BigDecimal(coin.getValue());
            int coinsToReturn = balance.divide(coinAsBigDecimal).intValue();
            if (coinsToReturn == 1){
                System.out.format("1 %s%n", coin.getName().substring(0, coin.getName().length() - 1));
            } else if (coinsToReturn > 1){
                System.out.format("%d %s%n", coinsToReturn, coin.getName());
            }
            balance = balance.remainder(coinAsBigDecimal);
        }
        System.out.println("\nThank You, Have A Good Day!\n");
    }
}
