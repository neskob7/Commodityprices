package com.example.commodityprices.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commodityprices.R;
import com.example.commodityprices.core.BarchartCallback;
import com.example.commodityprices.core.BarchartSdk;
import com.example.commodityprices.core.entities.Barchart;
import com.example.commodityprices.core.entities.BarchartResult;
import com.example.commodityprices.ui.CommodityAdapter;
import com.example.commodityprices.ui.MainActivity;
import com.example.commodityprices.ui.entities.Nesko;

import java.util.ArrayList;


public class CommodityFragment extends Fragment {

    private static final String TAG = "CommodityFragment";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CommodityAdapter commodityAdapter;

    /**
     * Array list of barchart results
     */
    private ArrayList<Nesko> results = new ArrayList<>();

    /**
     * Synchronized lock for results
     */
    private final Object resultLock = new Object();

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "CommodityFragment created");
        View view = inflater.inflate(R.layout.fragment_commodity, container, false);


        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        commodityAdapter = new CommodityAdapter(getContext());
        recyclerView.setAdapter(commodityAdapter);

        requestResults();

        commodityAdapter.setCommodityListener(new CommodityAdapter.CommodityListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "onItemClick: NAME " + results.get(position).getName());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //TODO: Probaj novu klasu za cuvanje UI podataka
    private void requestResults() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Todo Threads
                BarchartSdk.getInstance().getResults(new BarchartCallback<ArrayList<BarchartResult>>() {
                    @Override
                    public void onResultSuccess(ArrayList<BarchartResult> data) {

                        //Counts results
                        int loadingCount = 0;

                        //TODO Populate array list of barchart results
                        for (BarchartResult barchart : data) {
                            Log.d("Barchart UI", "Name = " + barchart.getName() + " Last price = " + barchart.getLastPrice()
                                    + " FIELDS " + barchart.getFiftyTwoWkHigh());

                            Nesko result = new Nesko(barchart.getName(), String.valueOf(barchart.getLastPrice()));

                            synchronized (resultLock) {
                                loadingCount++;
                                results.add(result);
                            }

                            if (loadingCount == data.size()) {
                                //TODO: Show UI Data via Recycler view
                                commodityAdapter.refreshResults(results);
                                Log.d("Barchart UI", "All results Loaded = " + loadingCount
                                        + " : " + results.size());

                            }
                        }
                    }

                    @Override
                    public void onResultFailed(String error) {
                        Log.e("Barchart UI", "ERROR = " + error);
                        //TODO Handle UI error, Show No data text view
                    }
                });
            }
        }).start();
    }

    @Override
    public void onResume() {


        super.onResume();
    }
}
