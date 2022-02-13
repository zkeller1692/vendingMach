package com.techelevator;

import java.math.BigDecimal;

public class Item {

    // Instance Variables
    private String itemCode;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemType;
    private int itemStock;
    private boolean inStock;

    // Constructor

    public Item(String itemCode, String itemName, String itemPriceStr, String itemType, int itemStock) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = new BigDecimal(itemPriceStr);
        this.itemType = itemType;
        this.itemStock = itemStock;

        this.inStock = true;
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

    // Behavior methods
    public void removeItemFromStock() {
        if (itemStock > 0) {
            itemStock -= 1;
        }
    }

    public void printPurchaseMessage() {
        switch (itemType) {
            case "Chip":
                System.out.println("Crunch Crunch, Yum!");
                break;
            case "Candy":
                System.out.println("Munch Munch, Yum!");
                break;
            case "Drink":
                System.out.println("Glug Glug, Yum!");
                break;
            case "Gum":
                System.out.println("Chew Chew, Yum!");
                break;
        }
    }

    // To String
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", itemCode, itemName, itemPrice, itemType, itemStock);
    }
}
