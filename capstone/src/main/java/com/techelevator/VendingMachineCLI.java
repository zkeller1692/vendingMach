package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
    // Vending Machine constants
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

    private static final int MAX_ITEM_STOCK_PER_ITEM = 5;

    // Create instances of objects used by Vending Machine
    private Menu menu;
    public Inventory inventory = new Inventory(MAX_ITEM_STOCK_PER_ITEM);
    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        String nextProcess = MAIN_MENU;

        while (true) {

            nextProcess = vendingMachineProcesses(nextProcess);

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

    public String vendingMachineProcesses(String process) {
        switch (process) {
            case MAIN_MENU:
                System.out.println("Do the Main Menu thing...");
                return (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            case MAIN_MENU_OPTION_DISPLAY_ITEMS:
                System.out.println("Do the Display Items thing...");
                inventory.printInventory();
                return MAIN_MENU;
            case MAIN_MENU_OPTION_PURCHASE:
                System.out.println("Do the Purchase thing...");
                return (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            case MAIN_MENU_OPTION_EXIT:
                System.out.println("Do the Exit thing...");
                System.exit(0);
            case PURCHASE_MENU_OPTIONS_FEED_MONEY:
                System.out.println("Do the Feed money thing...");
                return MAIN_MENU;
            case PURCHASE_MENU_OPTIONS_SELECT_PRODUCT:
                System.out.println("Do the Select Product thing...");
                return MAIN_MENU;
            case PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION:
                System.out.println("Do the Finish Transaction thing...");
                return MAIN_MENU;
            case DISPENSE_PRODUCT:
                System.out.println("Do the Dispense thing...");
                return MAIN_MENU;
            default:
                return null;
            }
        }
}
