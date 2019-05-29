package com.nesko_apps.commodityprices.ui.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Commodity implements Parcelable {

    private String name;
    private String lastPrice;
    private String priceOpen;
    private String priceClose;
    private String symbol;
    private String priceLow;
    private String priceHigh;
    private double netChange;
    private String volume;
    private String yearHigh;

    public Commodity(String name, String lastPrice, String priceOpen, String priceClose,
                     String symbol, String priceLow, String priceHigh, double netChange,
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


    protected Commodity(Parcel in) {
        name = in.readString();
        lastPrice = in.readString();
        priceOpen = in.readString();
        priceClose = in.readString();
        symbol = in.readString();
        priceLow = in.readString();
        priceHigh = in.readString();
        netChange = in.readDouble();
        volume = in.readString();
        yearHigh = in.readString();

        Log.d("PARCEL", "Commodity name  = " + name);
    }

    public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
        @Override
        public Commodity createFromParcel(Parcel in) {

            Log.d("PARCEL", "CREATOR Parcel in = " + in);
            return new Commodity(in);
        }

        @Override
        public Commodity[] newArray(int size) {
            return new Commodity[size];
        }
    };

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

    public double getNetChange() {
        return netChange;
    }

    public String getVolume() {
        return volume;
    }

    public String getYearHigh() {
        return yearHigh;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastPrice);
        dest.writeString(priceOpen);
        dest.writeString(priceClose);
        dest.writeString(symbol);
        dest.writeString(priceLow);
        dest.writeString(priceHigh);
        dest.writeDouble(netChange);
        dest.writeString(volume);
        dest.writeString(yearHigh);

        Log.d("PARCEL", "writeToParcel dest = " + dest);
    }


}
