
package com.nesko_apps.commodityprices.core.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Barchart Result
 */
public class BarchartResult {

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("exchange")
    @Expose
    private String exchange;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("dayCode")
    @Expose
    private String dayCode;

    @SerializedName("serverTimestamp")
    @Expose
    private String serverTimestamp;

    @SerializedName("mode")
    @Expose
    private String mode;

    @SerializedName("lastPrice")
    @Expose
    private Double lastPrice;

    @SerializedName("tradeTimestamp")
    @Expose
    private String tradeTimestamp;

    @SerializedName("netChange")
    @Expose
    private Double netChange;

    @SerializedName("percentChange")
    @Expose
    private Double percentChange;

    @SerializedName("unitCode")
    @Expose
    private String unitCode;

    @SerializedName("open")
    @Expose
    private Double open;

    @SerializedName("high")
    @Expose
    private Double high;

    @SerializedName("low")
    @Expose
    private Double low;

    @SerializedName("close")
    @Expose
    private Double close;

    @SerializedName("flag")
    @Expose
    private String flag;

    @SerializedName("volume")
    @Expose
    private Integer volume;

    @SerializedName("fiftyTwoWkHigh")
    @Expose
    private Double fiftyTwoWkHigh;

    @SerializedName("fiftyTwoWkHighDate")
    @Expose
    private String fiftyTwoWkHighDate;

    @SerializedName("fiftyTwoWkLow")
    @Expose
    private Double fiftyTwoWkLow;

    @SerializedName("fiftyTwoWkLowDate")
    @Expose
    private String fiftyTwoWkLowDate;

    public String getSymbol() {
        return symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getDayCode() {
        return dayCode;
    }

    public String getServerTimestamp() {
        return serverTimestamp;
    }

    public String getMode() {
        return mode;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public String getTradeTimestamp() {
        return tradeTimestamp;
    }

    public Double getNetChange() {
        return netChange;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public Double getOpen() {
        return open;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getClose() {
        return close;
    }

    public String getFlag() {
        return flag;
    }

    public Integer getVolume() {
        return volume;
    }

    public Double getFiftyTwoWkHigh() {
        return fiftyTwoWkHigh;
    }

    public String getFiftyTwoWkHighDate() {
        return fiftyTwoWkHighDate;
    }

    public Double getFiftyTwoWkLow() {
        return fiftyTwoWkLow;
    }

    public String getFiftyTwoWkLowDate() {
        return fiftyTwoWkLowDate;
    }
}
