package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    // Class variables
    public static final int ERROR_READING_INVENTORY = 1;

    // Instance variables
    private File path = new File ("vendingmachine.csv");
    private int maxItemStockPerItem;
    private Map<String, Item> inventoryMap = new HashMap<>();

    // Constructor
    public Inventory(int maxItemStockPerItem) {
        this.maxItemStockPerItem = maxItemStockPerItem;
        loadInventory();
    }

    // Getters
    public String[] getItemCodes() {
        return (String[]) inventoryMap.keySet().toArray();
    }
    public Item[] getItems() {
        return (Item[]) inventoryMap.values().toArray();
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
        for (Item item : getItems()) {
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
            inventoryMap.put(itemCode, item);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unable to load this item into inventory.");
        }
    }
}
