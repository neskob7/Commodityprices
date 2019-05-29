package com.example.commodityprices.core.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Currency {

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("rates")
    @Expose
    private CurrencyRate rates;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public CurrencyRate getRates() {
        return rates;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
