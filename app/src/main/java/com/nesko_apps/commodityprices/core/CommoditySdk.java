package com.nesko_apps.commodityprices.core;

import android.util.Log;

import com.nesko_apps.commodityprices.core.entities.Barchart;
import com.nesko_apps.commodityprices.core.entities.BarchartResult;
import com.nesko_apps.commodityprices.core.entities.Constants;
import com.nesko_apps.commodityprices.core.entities.Currency;
import com.nesko_apps.commodityprices.core.entities.CurrencyRate;
import com.nesko_apps.commodityprices.core.entities.ExchangeRate;
import com.nesko_apps.commodityprices.core.retrofit.BarchartApiEndpoint;
import com.nesko_apps.commodityprices.core.retrofit.CurrencyApiEndPoint;
import com.nesko_apps.commodityprices.core.retrofit.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Commodity SDK Singleton Helper
 */
public class CommoditySdk {

    private static final String TAG = "CommoditySdk";

    /**
     * Barchart instance
     */
    private static CommoditySdk instance = null;

    /**
     * Get barchart instance
     *
     * @return instance
     */
    public static CommoditySdk getInstance() {
        if (instance == null) {
            instance = new CommoditySdk();
        }
        return instance;
    }

    private CommoditySdk() {

    }

    public void getBarchartResults(final AsyncCallback<ArrayList<BarchartResult>> callback) {

        BarchartApiEndpoint service = RetrofitService.getRetrofitInstance(Constants.BARCHART_BASE_URL)
                .create(BarchartApiEndpoint.class);
        Call<Barchart> callable = service.getResults(Constants.BARCHART_API_KEY, Constants.BARCHART_SYMBOLS,
                Constants.BARCHART_FIELDS);

        callable.enqueue(new Callback<Barchart>() {
            @Override
            public void onResponse(Call<Barchart> call, Response<Barchart> response) {

                if (response.body() == null) {
                    Log.e(TAG, "Response Success, response body not initialized");
                    callback.onReceive(new ArrayList<BarchartResult>());
                    return;
                }

                ArrayList<BarchartResult> results = response.body().getResults();

                if (results == null) {
                    results = new ArrayList<>();
                    Log.e(TAG, "Response Success, empty results list");
                    callback.onReceive(results);
                    return;
                }

                Log.d(TAG, "Response Success, results size = " + results.size());
                callback.onReceive(results);
            }

            @Override
            public void onFailure(Call<Barchart> call, Throwable error) {
                Log.e(TAG, "Response Failed, Error = " + error.getMessage());
                callback.onFailed(error.getMessage());
            }
        });
    }

    public void getCurrencyRates(final AsyncCallback<ArrayList<ExchangeRate>> callback) {

        CurrencyApiEndPoint service = RetrofitService.getRetrofitInstance(Constants.CURRENCY_BASE_URL)
                .create(CurrencyApiEndPoint.class);
        Call<Currency> callable = service.getRates(Constants.CURRENCY_ACCESS_KEY, Constants.CURRENCY_SYMBOLS);

        callable.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                Log.d(TAG, "onResponse: base " + response.body().getBase());
                Log.d(TAG, "onResponse: body " + response.body().getRates());
                Log.d(TAG, "onResponse: body " + response.body().getTimestamp());

                Currency currency = response.body();

                CurrencyRate currencyRate = currency.getRates();

                String base = currency.getBase() + " / ";
                Log.d(TAG, "onResponse: " + currencyRate.getUSD() + " " + currencyRate.getRSD());

                ArrayList<ExchangeRate> exchangeRates = new ArrayList<>();

                exchangeRates.add(new ExchangeRate(base + "USD", String.valueOf(currencyRate.getUSD())));
                exchangeRates.add(new ExchangeRate(base + "RSD", String.valueOf(currencyRate.getRSD())));
                exchangeRates.add(new ExchangeRate(base + "AED", String.valueOf(currencyRate.getAED())));
                exchangeRates.add(new ExchangeRate(base + "GBP", String.valueOf(currencyRate.getGBP())));
                exchangeRates.add(new ExchangeRate(base + "JPY", String.valueOf(currencyRate.getJPY())));
                exchangeRates.add(new ExchangeRate(base + "CHF", String.valueOf(currencyRate.getCHF())));
                exchangeRates.add(new ExchangeRate(base + "BRL", String.valueOf(currencyRate.getBRL())));
                exchangeRates.add(new ExchangeRate(base + "ARS", String.valueOf(currencyRate.getARS())));
                callback.onReceive(exchangeRates);
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
            }
        });

    }


}
