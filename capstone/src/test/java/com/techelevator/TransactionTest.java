package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TransactionTest {
        Transaction transaction;
    @Before
    public void setup(){
        transaction = new Transaction();
    }

    // Test feedMoney method
    @Test
    public void feeding_five_dollars_makes_balance_five_dollars(){
        transaction.feedMoney("5.00");
        BigDecimal newBalance = transaction.getBalance();

        Assert.assertEquals("New balance value is unexpected", new BigDecimal("5.00"), newBalance);
    }

    @Test
    public void feeding_zero_dollars_makes_balance_zero_dollars(){
        transaction.feedMoney("0.00");
        BigDecimal newBalance = transaction.getBalance();

        Assert.assertTrue("New balance value is unexpected", newBalance.compareTo(BigDecimal.ZERO) == 0);
    }

    @Test
    public void feeding_negative_five_dollars_makes_balance_zero_dollars(){
        transaction.feedMoney("-5.00");
        BigDecimal newBalance = transaction.getBalance();

        Assert.assertTrue("New balance value is unexpected", newBalance.compareTo(BigDecimal.ZERO) == 0);
    }


    // Test buyItemMethod
    @Test
    public void buying_item_reduces_item_stock_by_one(){
        Item testItem = new Item("A1", "Honey Buns", "2.45", "Candy", 5);
        transaction.feedMoney("5.00");

        transaction.buyItem(testItem);

        Assert.assertEquals("Unexpected Item Stock", 4, testItem.getItemStock());
    }


}
