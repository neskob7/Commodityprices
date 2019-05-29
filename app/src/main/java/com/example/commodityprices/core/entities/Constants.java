package com.example.commodityprices.core.entities;

public class Constants {

    //https://marketdata.websol.barchart.com/getQuote.json?apikey=13084450b346c9dce6bbb63c2924e9b7&symbols=ZCK19
    public static final String BARCHART_API_KEY = "13084450b346c9dce6bbb63c2924e9b7";
    public static final String BARCHART_BASE_URL = "https://marketdata.websol.barchart.com";
    public static final String BARCHART_SYMBOLS = "ZWN19, ZCN19, ZSN19, ZMN19, ZRN19, ZON19";
    //todo add dynamic date selection
    public static final String BARCHART_FIELDS = "fiftyTwoWkHigh";


    //http://data.fixer.io/api/latest?access_key=bb36d039f3aad2d90d440f60253cc7c0&symbols=USD,RSD,JPY,
    // GBP,CHF,ARS,BRL,AED%20&format=1
    public static final String CURRENCY_ACCESS_KEY = "bb36d039f3aad2d90d440f60253cc7c0";
    public static final String CURRENCY_BASE_URL = "http://data.fixer.io/api/";
    public static final String CURRENCY_BASE = "EUR";
    public static final String CURRENCY_SYMBOLS = "USD,RSD,JPY,GBP,CHF,ARS,BRL,AED";


}
