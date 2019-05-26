package com.example.commodityprices.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commodityprices.R;

public class CurrencyFragment extends Fragment {

    private static final String TAG = "CurrencyFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "CurrencyFragment created");
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        return view;
    }

}
