package com.nesko_apps.commodityprices.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesko_apps.commodityprices.R;
import com.nesko_apps.commodityprices.core.AsyncCallback;
import com.nesko_apps.commodityprices.core.CommoditySdk;
import com.nesko_apps.commodityprices.core.entities.ExchangeRate;
import com.nesko_apps.commodityprices.ui.CurrencyAdapter;

import java.util.ArrayList;

public class CurrencyFragment extends Fragment {

    private static final String TAG = "CurrencyFragment";

    private ArrayList<String> tempList = new ArrayList<>();
    private RecyclerView recyclerView2;

    private RecyclerView.LayoutManager layoutManager;
    private CurrencyAdapter currencyAdapter;

//    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "CurrencyFragment created");
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        recyclerView2 = view.findViewById(R.id.recyclerview2);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);

//        progressBar = view.findViewById(R.id.progress_bar2);

        currencyAdapter = new CurrencyAdapter(getContext());
        recyclerView2.setAdapter(currencyAdapter);


        requestRates();


        return view;
    }


    private void requestRates() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                CommoditySdk.getInstance().getCurrencyRates(new AsyncCallback<ArrayList<ExchangeRate>>() {
                    @Override
                    public void onReceive(ArrayList<ExchangeRate> data) {
                        currencyAdapter.refreshAdapter(data);
                    }

                    @Override
                    public void onFailed(String error) {

                    }
                });
            }
        }).start();


    }


}
