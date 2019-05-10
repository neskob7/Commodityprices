package com.example.commodityprices.ui.entities;

public class Commodity {

    private String name;
    private String lastPrice;
    private String priceOpen;
    private String priceClose;

    public Commodity(String name, String lastPrice, String priceOpen, String priceClose) {
        this.name = name;
        this.lastPrice = lastPrice;
        this.priceOpen = priceOpen;
        this.priceClose = priceClose;
    }

    public String getName() {
        return name;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public String getPriceOpen() {
        return priceOpen;
    }

    public String getPriceClose() {
        return priceClose;
    }

}
