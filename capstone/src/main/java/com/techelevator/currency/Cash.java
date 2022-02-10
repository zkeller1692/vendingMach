package com.techelevator.currency;

import java.math.BigDecimal;

public enum Cash {

    ONE_DOLLAR_BILL("1.00"),
    TWO_DOLLAR_BILL("2.00"),
    FIVE_DOLLAR_BILL("5.00"),
    TEN_DOLLAR_BILL("10.00"),
    TWENTY_DOLLAR_BILL("20.00");

    public final String value;

    private static final Cash[] VALID_CASH = {ONE_DOLLAR_BILL, TWO_DOLLAR_BILL, FIVE_DOLLAR_BILL, TEN_DOLLAR_BILL,
            TWENTY_DOLLAR_BILL};

    // Constructor
    Cash(String value) {
        this.value = value;
    }

    // Getter
    public static String[] getValidCash() {
        String[] cashStr = new String[Cash.values().length];
        int i = 0;
        for (Cash cash : Cash.values()) {
            cashStr[i] = cash.toString();
            i++;
        }
        return cashStr;
    }

    public String getValue() {
        return value;
    }

    // Built-ins Override
    @Override
    public String toString() {
        return getValue();
    }
}
