package com.example.commodityprices.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.commodityprices.R;
import com.example.commodityprices.ui.fragments.CommodityFragment;
import com.example.commodityprices.ui.fragments.CurrencyFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonCommodity;
    private Button buttonCurrency;

    private enum Selection {
        COMMODITY,
        CURRENCY
    }

    private Selection active;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCommodity = findViewById(R.id.btnCommodity);
        buttonCurrency = findViewById(R.id.btnCurrency);

        // default fragment
        //TODO ON ROTATE SAVE PREVIOUS ACTIVE VIEW
        updateView(Selection.COMMODITY);

        buttonCommodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (active != Selection.COMMODITY) {
                    updateView(Selection.COMMODITY);
                }
            }
        });

        buttonCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (active != Selection.CURRENCY) {
                    updateView(Selection.CURRENCY);
                }
            }
        });

        //TODO: Temporary UI Test
    }

    /**
     * Open fragment view
     *
     * @param fragment fragment to open
     */
    private void openFragment(final Fragment fragment) {
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

    private void updateView(Selection selection) {
        this.active = selection;
        Log.d("UpdateView", "Current active selection = " + selection);

        //todo openFragment(new CommodityFragment());

        switch (selection) {
            case COMMODITY:
                openFragment(new CommodityFragment());
                break;
            case CURRENCY:
                openFragment(new CurrencyFragment());
                break;
            default:
                Log.w("UpdateView", "Active selection not supported " + selection);
                break;
        }

        buttonBackground(selection);
    }

    private void buttonBackground(Selection selection) {
        switch (selection) {
            case COMMODITY:
                buttonCommodity.setBackgroundResource(R.drawable.pressed_state);
                buttonCurrency.setBackgroundResource(R.drawable.default_state);
                break;
            case CURRENCY:
                buttonCurrency.setBackgroundResource(R.drawable.pressed_state);
                buttonCommodity.setBackgroundResource(R.drawable.default_state);
                break;
            default:
                break;
        }
    }
}
