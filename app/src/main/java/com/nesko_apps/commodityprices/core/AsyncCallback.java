package com.nesko_apps.commodityprices.core;

/**
 * Async Callback
 *
 * @param <T> callback data
 * @author Nesko Mandic
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
