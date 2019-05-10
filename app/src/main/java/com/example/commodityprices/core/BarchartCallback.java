package com.example.commodityprices.core;

/**
 * Barchart Callback
 *
 * @param <T> callback data
 * @author Commodity Mandic
 */
public interface BarchartCallback<T extends Object> {

    /**
     * Call to receive success data
     *
     * @param data received data
     */
    void onResultSuccess(T data);

    /**
     * Call to notify response error message
     *
     * @param error error message
     */
    void onResultFailed(String error);
}
