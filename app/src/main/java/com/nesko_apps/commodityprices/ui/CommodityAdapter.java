package com.nesko_apps.commodityprices.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nesko_apps.commodityprices.R;
import com.nesko_apps.commodityprices.ui.entities.Commodity;

import java.util.ArrayList;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.CommodityViewHolder> {

    private Context context;
    private ArrayList<Commodity> commodities = new ArrayList<>();
    private static final String TAG = "CommodityAdapter";
    private CommodityListener commodityListener;

    public CommodityAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CommodityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = (View) LayoutInflater.from(context).inflate(R.layout.commodity_layout,
                viewGroup, false);

        final CommodityViewHolder commodityViewHolder = new CommodityViewHolder(view);

        //todo click listener by position

        commodityViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: POSITION: " + commodityViewHolder.getAdapterPosition());
                if (commodityListener != null) {
                    commodityListener.onItemClick(commodityViewHolder.getAdapterPosition());
                }
            }
        });

        return commodityViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityViewHolder viewHolder, int position) {
        Commodity commodity = commodities.get(position);
        viewHolder.name.setText(commodity.getName());
        viewHolder.netChange.setText(String.valueOf(commodity.getNetChange()));
        if(commodity.getNetChange() > 0) {
            viewHolder.netChange.setTextColor(Color.GREEN);
        }else {
            viewHolder.netChange.setTextColor(Color.RED);
        }
        viewHolder.priceOpen.setText("Open " + commodity.getPriceOpen());
        viewHolder.priceClose.setText("Close " + commodity.getPriceClose());

        //TODO add price close and open
    }

    @Override
    public int getItemCount() {
        return commodities.size();
    }

    public static class CommodityViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView netChange;
        private RelativeLayout rootView;
        private TextView priceOpen;
        private TextView priceClose;



        public CommodityViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            netChange = itemView.findViewById(R.id.netChange);
            rootView = itemView.findViewById(R.id.root_view);
            priceClose = itemView.findViewById(R.id.priceClose);
            priceOpen = itemView.findViewById(R.id.priceOpen);
        }
    }

    public void refreshData(ArrayList<Commodity> items) {
        this.commodities = items;
        notifyDataSetChanged();
    }

    public interface CommodityListener {
        void onItemClick(int position);
    }

    public void setCommodityListener(CommodityListener commodityListener) {
        this.commodityListener = commodityListener;
    }

}
