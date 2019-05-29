package com.nesko_apps.commodityprices.core.retrofit;

import com.nesko_apps.commodityprices.core.entities.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyApiEndPoint {
    @GET("/latest?")
    Call<Currency> getRates(@Query("access_key") String accessKey,
                            @Query("symbols") String symbols);


}
