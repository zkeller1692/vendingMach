package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

    private static final String MAIN_MENU = "Main Menu";

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
            MAIN_MENU_OPTION_EXIT};

    private static final String PURCHASE_MENU_OPTIONS_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTIONS_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTIONS_FEED_MONEY,
            PURCHASE_MENU_OPTIONS_SELECT_PRODUCT, PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION};

    private static final String DISPENSE_PRODUCT = "Dispense";


    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
//			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//
//			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				// display vending machine items
//			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				// do purchase
//			}

        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


    public void vendingMachineProcesses(String process) {
        switch (process) {
            case MAIN_MENU:
                System.out.println("Do the Main Menu thing...");
                break;
            case MAIN_MENU_OPTION_DISPLAY_ITEMS:
                System.out.println("Do the Display Items thing...");
                break;
            case MAIN_MENU_OPTION_PURCHASE:
                System.out.println("Do the Purchase thing...");
                break;
            case MAIN_MENU_OPTION_EXIT:
                System.out.println("Do the Exit thing...");
                break;
            case PURCHASE_MENU_OPTIONS_FEED_MONEY:
                System.out.println("Do the Feed money thing...");
                break;
            case PURCHASE_MENU_OPTIONS_SELECT_PRODUCT:
                System.out.println("Do the Select Product thing...");
                break;
            case PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION:
                System.out.println("Do the Finish Transaction thing...");
                break;
            case DISPENSE_PRODUCT:
                System.out.println("Do the Dispense thing...");
                break;
        }
    }
}
