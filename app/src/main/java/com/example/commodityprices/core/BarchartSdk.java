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
        //Todo Temporary Retrofit test
        BarchartApiEndpoint service = RetrofitService.getRetrofitInstance().create(BarchartApiEndpoint.class);
        Call<Barchart> callable = service.getResults(Constants.API_KEY, Constants.SYMBOLS, Constants.FIELDS);

        callable.enqueue(new Callback<Barchart>() {
            @Override
            public void onResponse(Call<Barchart> call, Response<Barchart> response) {

                if (response.body() == null) {
                    Log.e("Barchart", "Response body not initialized");
                    callback.onResultSuccess(new ArrayList<BarchartResult>());
                    return;
                }

                ArrayList<BarchartResult> results = (ArrayList<BarchartResult>) response.body().getResults();
                Log.d("Barchart", "Response Success, results size = " + results.size());
                callback.onResultSuccess(results);
            }

            @Override
            public void onFailure(Call<Barchart> call, Throwable error) {
                Log.e("Barchart", "Response Failed, Error = " + error.getMessage());
                callback.onResultFailed(error.getMessage());
            }
        });
    }

}
