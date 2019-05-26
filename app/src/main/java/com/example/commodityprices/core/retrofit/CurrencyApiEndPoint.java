package com.example.commodityprices.core.retrofit;

import com.example.commodityprices.core.entities.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyApiEndPoint {
    @GET("/latest?")
    Call<Currency> getRates(@Query("access_key") String accessKey,
                            @Query("symbols") String symbols);


}
