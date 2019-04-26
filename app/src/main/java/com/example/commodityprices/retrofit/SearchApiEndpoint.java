package com.example.commodityprices.retrofit;

import com.example.commodityprices.barchart.BarchartResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SearchApiEndpoint {


    @GET("/")
    Call<BarchartResponse> searchBARCHART(@QueryMap Map<String, String> query);


}
