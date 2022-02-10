package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    // Class variables
    public static final int ERROR_READING_INVENTORY = 1;

    // Instance variables
    File path = new File ("vendingmachine.csv");
    int maxItemStockPerItem;
    List<Item> inventoryList = new ArrayList<>();

    public Inventory(int maxItemStockPerItem) {
        this.maxItemStockPerItem = maxItemStockPerItem;
        loadInventory();
    }

    public void loadInventory() {
        try(Scanner inputFile = new Scanner(path)) {
            while (inputFile.hasNextLine()) {

                // Each row in file represents 1 item in inventory
                String item = inputFile.nextLine();

                // Parse string to get item attributes
                createItem(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Out of order");
            System.exit(ERROR_READING_INVENTORY);
        }
    }

    public void printInventory() {
        for (Item item : inventoryList) {
            System.out.println(item);
        }
    }

    private void createItem(String itemData) {
        String[] itemDataArray = itemData.split("\\|");

        try {
            String itemCode = itemDataArray[0];
            String itemName = itemDataArray[1];
            String itemPrice = itemDataArray[2];
            String itemType = itemDataArray[3];

            Item item = new Item(itemCode, itemName, itemPrice, itemType, maxItemStockPerItem);
            inventoryList.add(item);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unable to load this item into inventory.");
        }
    }
}
