package com.techelevator;

import java.math.BigDecimal;

public class Item {

    // Instance Variables
    private String itemCode;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemType;
    private int itemStock;

    // Constructor

    public Item(String itemCode, String itemName, String itemPriceStr, String itemType, int itemStock) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = new BigDecimal(itemPriceStr);
        this.itemType = itemType;
        this.itemStock = itemStock;
    }

    // Getters

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemStock() {
        return itemStock;
    }

    // To String
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", itemCode, itemName, itemPrice, itemType, itemStock);
    }
}
