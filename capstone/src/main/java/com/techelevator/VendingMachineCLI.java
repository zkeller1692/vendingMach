package com.techelevator;

import com.techelevator.currency.Cash;
import com.techelevator.view.Keypad;
import com.techelevator.view.Menu;

public class VendingMachineCLI {
    //TODO -- make these enums and put them in a separate class
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

    private static final int MAX_ITEM_STOCK_PER_ITEM = 5;


    // Create instances of objects used by Vending Machine
    private Menu menu;
    private Keypad keypad;
    public Inventory inventory = new Inventory(MAX_ITEM_STOCK_PER_ITEM);
    Transaction transaction = new Transaction();

    // Constructor
    public VendingMachineCLI(Menu menu, Keypad keypad) {
        this.menu = menu;
        this.keypad = keypad;
    }

    public void run() {

        String nextProcess = MAIN_MENU;

        while (true) {

            nextProcess = vendingMachineProcesses(nextProcess);
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        Keypad keypad = new Keypad(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu, keypad);
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
                System.out.format("Current money provided: $%s %n", transaction.getBalance());
                return (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            case MAIN_MENU_OPTION_EXIT:
                System.out.println("Do the Exit thing...");
                System.exit(0);
            case PURCHASE_MENU_OPTIONS_FEED_MONEY:
                String moneyToFeed = (String) menu.getChoiceFromOptions(Cash.getValidCash());
                transaction.feedMoney(moneyToFeed);
                System.out.println("Do the Feed money thing...");
                return MAIN_MENU_OPTION_PURCHASE;
            case PURCHASE_MENU_OPTIONS_SELECT_PRODUCT:
                System.out.println("Do the Select Product thing...");
                inventory.printInventory();
                // TODO -- Move Scanner create class to extend menu
                String itemCodeSelected = (String) menu.getChoiceFromOptions(inventory.getItemCodes());
                Item itemSelected = inventory.getItem(itemCodeSelected);
                transaction.buyItem(itemSelected);
                return MAIN_MENU_OPTION_PURCHASE;
            case PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION:
                System.out.println("Do the Finish Transaction thing...");
                // TODO -- make sure that new Transactions are being created at appropriate times
                //  Getting the machine ready for a new transaction is done right after old transaction is done
                transaction = new Transaction();
                return MAIN_MENU;
            default:
                return null;
            }
        }
}
