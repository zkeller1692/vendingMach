package com.techelevator;

import org.junit.Before;

public class InventoryTest {

    @Before
    public void setup() {
        Inventory inventory = new Inventory(5);


        // Create test items
        Item testItem1 = new Item("A1", "Honey Buns", "2.45", "Candy", 5);
        Item testItem2 = new Item("B3", "Dr. Pepper", "1.95", "Drink", 5);
        Item testItem3 = new Item("C4", "Goobey Bars", "4.45", "Candy", 5);


    }


}
