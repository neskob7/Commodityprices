
package com.nesko_apps.commodityprices.core.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Barchart
 */
public class Barchart {

    @SerializedName("status")
    @Expose
    private BarchartStatus status;
    @SerializedName("results")
    @Expose
    private ArrayList<BarchartResult> results;

    public BarchartStatus getStatus() {
        return status;
    }

    public ArrayList<BarchartResult> getResults() {
        return results;
    }
}
