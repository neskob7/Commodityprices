package com.nesko_apps.commodityprices.core.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyRate {

    @SerializedName("USD")
    @Expose
    private Double usd;

    @SerializedName("RSD")
    @Expose
    private Double rsd;

    @SerializedName("JPY")
    @Expose
    private Double jpy;

    @SerializedName("GBP")
    @Expose
    private Double gbp;

    @SerializedName("CHF")
    @Expose
    private Double chf;

    @SerializedName("ARS")
    @Expose
    private Double ars;

    @SerializedName("BRL")
    @Expose
    private Double brl;

    @SerializedName("AED")
    @Expose
    private Double aed;

    public Double getUSD() {
        return usd;
    }

    public Double getRSD() {
        return rsd;
    }

    public Double getJPY() {
        return jpy;
    }

    public Double getGBP() {
        return gbp;
    }

    public Double getCHF() {
        return chf;
    }

    public Double getARS() {
        return ars;
    }

    public Double getBRL() {
        return brl;
    }

    public Double getAED() {
        return aed;
    }

}
