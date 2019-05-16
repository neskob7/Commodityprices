package com.example.commodityprices.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.commodityprices.R;
import com.example.commodityprices.core.BarchartCallback;
import com.example.commodityprices.core.BarchartSdk;
import com.example.commodityprices.core.entities.BarchartResult;
import com.example.commodityprices.ui.CommodityAdapter;
import com.example.commodityprices.ui.DetailsActivity;
import com.example.commodityprices.ui.entities.Commodity;

import java.util.ArrayList;


public class CommodityFragment extends Fragment {

    private static final String TAG = "CommodityFragment";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CommodityAdapter commodityAdapter;
    private ProgressBar progressBar;

    /**
     * Array list of barchart results
     */
    private ArrayList<Commodity> commodities = new ArrayList<>();

    /**
     * Synchronized lock for commodity results
     */
    private final Object commodityLock = new Object();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "CommodityFragment created");
        View view = inflater.inflate(R.layout.fragment_commodity, container, false);

        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        commodityAdapter = new CommodityAdapter(getContext());
        recyclerView.setAdapter(commodityAdapter);

        //TODO Programmatically change visibility
        //Hint setVisibility(View.VISIBLE);

        Log.d("PROGRES ", "onCreateView: START " + System.currentTimeMillis());


        requestResults();

        commodityAdapter.setCommodityListener(new CommodityAdapter.CommodityListener() {
            @Override
            public void onItemClick(int position) {
                //TODO Open Extended details info

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                // intent.putExtra("position", commodities.get(position));
                startActivity(intent);


                Log.d(TAG, "onItemClick: NAME " + commodities.get(position).getName());
            }
        });

        return view;
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

                        //TODO Handle no results, Show No data text view -> data.size() = 0

                        //Counts results
                        int loadingCount = 0;

                        // Populate array list of barchart results
                        for (BarchartResult barchart : data) {
                            Log.d("Barchart UI", "Name = " + barchart.getName() +
                                    " Last price = " + barchart.getLastPrice()
                                    + " FIELDS " + barchart.getFiftyTwoWkHigh());


                            Commodity commodity = new Commodity(
                                    barchart.getName(),
                                    String.valueOf(barchart.getLastPrice()),
                                    String.valueOf(barchart.getOpen()),
                                    String.valueOf(barchart.getClose()),
                                    barchart.getSymbol(),
                                    String.valueOf(barchart.getLow()),
                                    String.valueOf(barchart.getHigh()),
                                    String.valueOf(barchart.getNetChange()),
                                    String.valueOf(barchart.getVolume()),
                                    String.valueOf(barchart.getFiftyTwoWkHigh())
                            );

                            Log.d(TAG, "onResultSuccess: Commodity object created" +
                                    commodity.getName() + " " + commodity.getSymbol()+ " " +
                                    commodity.getPriceLow() + " " + commodity.getYearHigh());

                            synchronized (commodityLock) {
                                loadingCount++;
                                commodities.add(commodity);
                            }

                            //All data loaded for sure
                            if (loadingCount == data.size()) {

                                progressBar.setVisibility(View.GONE);
                                //TODO: Show UI Data via Recycler view
                                commodityAdapter.refreshData(commodities);
                                Log.d("PROGRES ", "onCreateView: END " + System.currentTimeMillis());

                                Log.d("Barchart UI", "All results Loaded = " + loadingCount
                                        + " : " + commodities.size());

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
