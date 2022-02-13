package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Item;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Keypad extends Menu{

    private PrintWriter out;
    private Scanner in;

    public Keypad(InputStream input, OutputStream output){
        super(input, output);
    }

    //@Override
    public Object getChoiceFromOptions(Item[] items) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(items);
            choice = getChoiceFromUserInput(items);
        }
        return choice;
    }

    //@Override
    private Object getChoiceFromUserInput(Item[] items) {
        Object choice = null;
        String userInput = in.nextLine();
             for (Item item : items){
                 String itemCode = item.getItemCode();
                 if (itemCode.equals(userInput.toUpperCase())){
                     choice = itemCode;
                 }
            }
        if (choice == null) {
            out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" +
                    System.lineSeparator());
        }
        return choice;
    }

    //@Override
    private void displayMenuOptions(Item[] items) {
        out.println();
        for (Item item : items) {
            String itemCode = item.getItemCode();
            out.println(itemCode + ") " + item);
        }
        out.print(System.lineSeparator() + "Please choose an option >>> ");
        out.flush();
    }

}
