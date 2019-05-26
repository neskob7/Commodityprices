package com.example.commodityprices.core;

/**
 * Async Callback
 *
 * @param <T> callback data
 * @author Commodity Mandic
 */
public interface AsyncCallback<T extends Object> {

    /**
     * Call to receive success data
     *
     * @param data received data
     */
    void onReceive(T data);

    /**
     * Call to notify response error message
     *
     * @param error error message
     */
    void onFailed(String error);
}
