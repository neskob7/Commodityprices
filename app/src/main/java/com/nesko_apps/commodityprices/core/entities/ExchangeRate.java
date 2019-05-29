package com.nesko_apps.commodityprices.core.entities;

public class ExchangeRate {

    private String currencyPair;
    private String currencyValue;

    public ExchangeRate(String currencyPair, String currencyValue) {
        this.currencyPair = currencyPair;
        this.currencyValue = currencyValue;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }
}
