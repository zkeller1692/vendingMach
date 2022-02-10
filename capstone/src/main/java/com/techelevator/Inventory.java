package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {
    public static final int ERROR_READING_INVENTORY = 1;

    File path = new File ("vendingmachine.csv");

    public void printInventory() {
        try(Scanner inputFile = new Scanner(path)) {
            while (inputFile.hasNextLine()){
                System.out.println(inputFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Out of order");
            System.exit(ERROR_READING_INVENTORY);
        }
    }

}
