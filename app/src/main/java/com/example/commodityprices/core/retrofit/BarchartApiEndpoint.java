package com.example.commodityprices.core.retrofit;

import com.example.commodityprices.core.entities.Barchart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarchartApiEndpoint {

    @GET("/getQuote.json?")
    Call<Barchart> getResults(@Query("apikey") String apiKey,
                              @Query("symbols") String symbols,
                              @Query("fields") String fields);
}


