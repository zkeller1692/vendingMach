package com.techelevator;

import java.util.Scanner;

//TODO -- remove if this ends up not being used
public class UI {

    // Class Variables
    public static final Scanner keyboardInput = new Scanner(System.in);

    public static String getUserInput(String userPrompt) {
        prompt(userPrompt);
        return keyboardInput.nextLine();
    }

    public static void prompt(String message) {
        System.out.print(message);
    }

    public boolean validateInput() {
        System.out.println();
        return false;
    }
}
