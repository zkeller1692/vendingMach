package com.techelevator;

import com.techelevator.currency.Coins;

import java.math.BigDecimal;


public class Transaction {

    // Instance Variable
    private BigDecimal balance = new BigDecimal("0.00");

    // Getters
    public BigDecimal getBalance() {
        return balance;
    }

    // Setter
    private void setBalance(String transactionType, BigDecimal newBalance) {
        BigDecimal startingBalance = balance;
        balance = newBalance;
        BigDecimal endingBalance = balance;
        Log.addRecord(transactionType, startingBalance, endingBalance);
    }

    // Method

    public void feedMoney(String moneyToFeed) {
        // TODO -- High priority for testing
        BigDecimal addedMoney = new BigDecimal(moneyToFeed);
        if (addedMoney.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal newBalance = balance.add(addedMoney);
            setBalance("FEED MONEY", newBalance);
        }
    }

    public void buyItem(Item itemToBuy){
        //TODO -- High priority for testing
        BigDecimal itemPrice = itemToBuy.getItemPrice();
        boolean sufficientFunds = balance.compareTo(BigDecimal.ZERO) > 0 && !(itemPrice.compareTo(balance) > 0);
        boolean itemInStock = itemToBuy.getItemStock() > 0;
        if (sufficientFunds && itemInStock) {
            if (itemPrice.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal newBalance = balance.subtract(itemPrice);
                setBalance(itemToBuy.getItemName(), newBalance);
            }
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
        BigDecimal changeToReturn = balance;
        for (Coins coin : Coins.VALID_COINS){
            BigDecimal coinAsBigDecimal = new BigDecimal(coin.getValue());
            int coinsToReturn = changeToReturn.divide(coinAsBigDecimal).intValue();
            if (coinsToReturn == 1){
                System.out.format("1 %s%n", coin.getName().substring(0, coin.getName().length() - 1));
            } else if (coinsToReturn > 1){
                System.out.format("%d %s%n", coinsToReturn, coin.getName());
            }
            changeToReturn = changeToReturn.remainder(coinAsBigDecimal);
        }
        setBalance("GIVE CHANGE", changeToReturn); // in case vending machine can't return exact change -- should never happen
        System.out.println("\nThank You, Have A Good Day!\n");
    }
}
