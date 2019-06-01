package com.nesko_apps.commodityprices.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.nesko_apps.commodityprices.R;
import com.nesko_apps.commodityprices.ui.entities.Commodity;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";
    private TextView tvName;
    private TextView tvSymbol;
    private TextView tvLastPrice;
    private TextView tvNetChange;
    private TextView tvPriceOpen;
    private TextView tvPriceClose;
    private TextView tvVolume;
    private TextView tvNetChangeValue;

    private String priceUnits;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvName = findViewById(R.id.name);
        tvSymbol = findViewById(R.id.symbol);
        tvLastPrice = findViewById(R.id.lastPrice);
        tvNetChange = findViewById(R.id.netChange);
        tvPriceOpen = findViewById(R.id.priceOpen);
        tvPriceClose = findViewById(R.id.priceClose);
        tvVolume = findViewById(R.id.volume);
        tvNetChangeValue = findViewById(R.id.netChange2);



        Bundle data = getIntent().getExtras();
        Log.d(TAG, "onCreate DATA BUNDLE : " + data);

        if (data != null) {
            Commodity commodity = data.getParcelable("commodity");

            if (commodity != null) {

                if(commodity.getName().equals("Corn")|commodity.getName().equals("Wheat")
                        |commodity.getName().equals("Soybeans")|commodity.getName().equals("Oats")) {
                    priceUnits = "c/bu";
                }
                if(commodity.getName().equals("Soybean Meal")) {
                    priceUnits = "$/short tonne";
                }else {
                    priceUnits = "c/hundredweight";
                }

                tvName.setText("Commodity: " + commodity.getName());
                tvSymbol.setText("Cbot symbol: " + commodity.getSymbol());
                tvLastPrice.setText("Last price: " + commodity.getLastPrice() + " " + priceUnits);

                tvNetChange.setText("Net change: ");

                if(commodity.getNetChange() > 0) {
                    tvNetChangeValue.setTextColor(Color.GREEN);
                }else {
                    tvNetChangeValue.setTextColor(Color.RED);
                }

                tvNetChangeValue.setText(String.valueOf(commodity.getNetChange()));
                tvPriceOpen.setText("Price open: " + commodity.getPriceOpen());
                tvPriceClose.setText("Price close: " + commodity.getPriceClose());
                tvVolume.setText("Volume: " + commodity.getVolume());

                Log.d(TAG, "onCreate:  Commodity object " + commodity.getSymbol() + " " + commodity.getName());
            } else {
                Log.d(TAG, "onCreate: Commodity object not created");
//                VISIBLE NO DATA
            }


        } else {
            Log.e(TAG, "onCreate: BUNDLE ERROR - NO DATA " + data);
//            VISIBLE NO DATA
        }


    }
}
