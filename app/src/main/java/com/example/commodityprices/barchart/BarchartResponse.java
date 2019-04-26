package com.example.commodityprices.barchart;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BarchartResponse {


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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayCode() {
        return dayCode;
    }

    public void setDayCode(String dayCode) {
        this.dayCode = dayCode;
    }

    public String getServerTimestamp() {
        return serverTimestamp;
    }

    public void setServerTimestamp(String serverTimestamp) {
        this.serverTimestamp = serverTimestamp;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTradeTimestamp() {
        return tradeTimestamp;
    }

    public void setTradeTimestamp(String tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }

    public Double getNetChange() {
        return netChange;
    }

    public void setNetChange(Double netChange) {
        this.netChange = netChange;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getFiftyTwoWkHigh() {
        return fiftyTwoWkHigh;
    }

    public void setFiftyTwoWkHigh(Double fiftyTwoWkHigh) {
        this.fiftyTwoWkHigh = fiftyTwoWkHigh;
    }

    public String getFiftyTwoWkHighDate() {
        return fiftyTwoWkHighDate;
    }

    public void setFiftyTwoWkHighDate(String fiftyTwoWkHighDate) {
        this.fiftyTwoWkHighDate = fiftyTwoWkHighDate;
    }

    public Double getFiftyTwoWkLow() {
        return fiftyTwoWkLow;
    }

    public void setFiftyTwoWkLow(Double fiftyTwoWkLow) {
        this.fiftyTwoWkLow = fiftyTwoWkLow;
    }

    public String getFiftyTwoWkLowDate() {
        return fiftyTwoWkLowDate;
    }

    public void setFiftyTwoWkLowDate(String fiftyTwoWkLowDate) {
        this.fiftyTwoWkLowDate = fiftyTwoWkLowDate;
    }
}
