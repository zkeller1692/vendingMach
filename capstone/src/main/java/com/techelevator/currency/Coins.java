package com.techelevator.currency;

import java.math.BigDecimal;

public enum Coins {

    NICKLE("0.05", "nickles"),
    DIME("0.10", "dimes"),
    QUARTER("0.25", "quarters");

    public final String value;
    public final String name;

    public static final Coins[] VALID_COINS = {QUARTER, DIME, NICKLE};

    private Coins(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String[] getValidCoins() {
        String[] coinStr = new String[Coins.values().length];
        int i = 0;
        for (Coins coin : Coins.values()) {
            coinStr[i] = coin.toString();
            i++;
        }
        return coinStr;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // Built-ins Override
    @Override
    public String toString() {
        return getValue();
    }
}
