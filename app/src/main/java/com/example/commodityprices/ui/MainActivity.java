package com.example.commodityprices.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.commodityprices.R;
import com.example.commodityprices.core.BarchartCallback;
import com.example.commodityprices.core.BarchartSdk;
import com.example.commodityprices.core.entities.BarchartResult;
import com.example.commodityprices.ui.entities.Nesko;
import com.example.commodityprices.ui.fragments.CommodityFragment;
import com.example.commodityprices.ui.fragments.ExchangeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonCommodity;
    private Button buttonExchange;

    private boolean isCommodityCreated = false;
    private boolean isExchangeCreated = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCommodity = findViewById(R.id.btnCommodity);
        buttonExchange = findViewById(R.id.btnExchange);

        updateView(new CommodityFragment());
        isCommodityCreated = true;

        buttonCommodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isCommodityCreated) {
                    updateView(new CommodityFragment());
                    isCommodityCreated = true;
                    isExchangeCreated = false;
                }
            }
        });

        buttonExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExchangeCreated) {
                    updateView(new ExchangeFragment());
                    isExchangeCreated = true;
                    isCommodityCreated = false;
                }
            }
        });

        //TODO: Temporary UI Test
    }

    /**
     * Update fragment view
     *
     * @param fragment fragment to update
     */
    private void updateView(final Fragment fragment) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }



}
