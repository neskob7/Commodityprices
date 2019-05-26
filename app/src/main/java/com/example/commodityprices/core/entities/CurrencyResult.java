package com.example.commodityprices.core.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyResult {

    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("RSD")
    @Expose
    private Double rSD;
    @SerializedName("JPY")
    @Expose
    private Double jPY;
    @SerializedName("GBP")
    @Expose
    private Double gBP;
    @SerializedName("CHF")
    @Expose
    private Double cHF;
    @SerializedName("ARS")
    @Expose
    private Double aRS;
    @SerializedName("BRL")
    @Expose
    private Double bRL;
    @SerializedName("AED")
    @Expose
    private Double aED;

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getRSD() {
        return rSD;
    }

    public void setRSD(Double rSD) {
        this.rSD = rSD;
    }

    public Double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getARS() {
        return aRS;
    }

    public void setARS(Double aRS) {
        this.aRS = aRS;
    }

    public Double getBRL() {
        return bRL;
    }

    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    public Double getAED() {
        return aED;
    }

    public void setAED(Double aED) {
        this.aED = aED;
    }
}
