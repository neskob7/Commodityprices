package com.example.commodityprices.ui;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.commodityprices.R;
import com.example.commodityprices.core.entities.ExchangeRate;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private Context context;
    private ArrayList<ExchangeRate> exchangeRates = new ArrayList<>();


    public CurrencyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = (View) LayoutInflater.from(context).inflate(R.layout.currency_layout,
                viewGroup, false);

        final CurrencyAdapter.CurrencyViewHolder currencyViewHolder = new CurrencyViewHolder(view);


        return currencyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder viewHolder, int position) {

        ExchangeRate exchangeRate = exchangeRates.get(position);
        viewHolder.currencyPair.setText(exchangeRate.getCurrencyPair());
        viewHolder.currencyRate.setText(exchangeRate.getCurrencyValue());
    }


    @Override
    public int getItemCount() {
        return exchangeRates.size();
    }

    public void refreshAdapter(ArrayList<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
        notifyDataSetChanged();
    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder {

        private TextView currencyPair;
        private TextView currencyRate;

        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);

            currencyPair = itemView.findViewById(R.id.currencyPair);
            currencyRate = itemView.findViewById(R.id.currencyRate);

        }
    }
}
