package com.example.commodityprices.core.retrofit;

import android.util.Log;

import com.example.commodityprices.core.entities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String TAG = "RetrofitService";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        Log.d(TAG, "getRetrofitInstance Retrofit: " + retrofit.baseUrl());
        return retrofit;
    }
}
