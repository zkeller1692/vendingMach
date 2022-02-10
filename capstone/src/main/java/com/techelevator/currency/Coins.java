package com.techelevator.currency;

import java.math.BigDecimal;

public enum Coins {

    NICKEL(new BigDecimal("0.05")),
    DIME(new BigDecimal("0.10")),
    QUARTER(new BigDecimal("0.25"));

    public final BigDecimal value;

    private Coins(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
