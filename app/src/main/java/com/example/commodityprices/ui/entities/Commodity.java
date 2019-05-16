package com.example.commodityprices.ui.entities;

public class Commodity {

    private String name;
    private String lastPrice;
    private String priceOpen;
    private String priceClose;
    private String symbol;
    private String priceLow;
    private String priceHigh;
    private String netChange;
    private String volume;
    private String yearHigh;

    public Commodity(String name, String lastPrice, String priceOpen, String priceClose,
                     String symbol, String priceLow, String priceHigh, String netChange,
                     String volume, String yearHigh) {
        this.name = name;
        this.lastPrice = lastPrice;
        this.priceOpen = priceOpen;
        this.priceClose = priceClose;
        this.symbol = symbol;
        this.priceLow = priceLow;
        this.priceHigh = priceHigh;
        this.netChange = netChange;
        this.volume = volume;
        this.yearHigh = yearHigh;
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

    public String getSymbol() {
        return symbol;
    }

    public String getPriceLow() {
        return priceLow;
    }

    public String getPriceHigh() {
        return priceHigh;
    }

    public String getNetChange() {
        return netChange;
    }

    public String getVolume() {
        return volume;
    }

    public String getYearHigh() {
        return yearHigh;
    }


}
