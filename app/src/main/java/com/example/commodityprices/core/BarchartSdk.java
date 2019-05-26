package com.example.commodityprices.core;

import android.util.Log;

import com.example.commodityprices.core.entities.Barchart;
import com.example.commodityprices.core.entities.BarchartResult;
import com.example.commodityprices.core.entities.Constants;
import com.example.commodityprices.core.retrofit.BarchartApiEndpoint;
import com.example.commodityprices.core.retrofit.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Barchart SDK Singleton Helper
 */
public class BarchartSdk {

    private static final String TAG = "BarchartSdk";

    /**
     * Barchart instance
     */
    private static BarchartSdk instance = null;

    /**
     * Get barchart instance
     *
     * @return instance
     */
    public static BarchartSdk getInstance() {
        if (instance == null) {
            instance = new BarchartSdk();
        }
        return instance;
    }

    private BarchartSdk() {

    }


    public void getResults(final BarchartCallback<ArrayList<BarchartResult>> callback) {

        BarchartApiEndpoint service = RetrofitService.getRetrofitInstance(Constants.BASE_URL_BARCHART).create(BarchartApiEndpoint.class);
        Call<Barchart> callable = service.getResults(Constants.API_KEY_BARCHART, Constants.SYMBOLS_BARCHART, Constants.FIELDS_BARCHART);

        callable.enqueue(new Callback<Barchart>() {
            @Override
            public void onResponse(Call<Barchart> call, Response<Barchart> response) {

                if (response.body() == null) {
                    Log.e(TAG, "Response Success, response body not initialized");
                    callback.onResultSuccess(new ArrayList<BarchartResult>());
                    return;
                }

                ArrayList<BarchartResult> results = (ArrayList<BarchartResult>) response.body().getResults();

                if (results == null) {
                    results = new ArrayList<>();
                    Log.e(TAG, "Response Success, empty results list");
                    callback.onResultSuccess(results);
                    return;
                }

                Log.d(TAG, "Response Success, results size = " + results.size());
                callback.onResultSuccess(results);
            }

            @Override
            public void onFailure(Call<Barchart> call, Throwable error) {
                Log.e(TAG, "Response Failed, Error = " + error.getMessage());
                callback.onResultFailed(error.getMessage());
            }
        });
    }

}
