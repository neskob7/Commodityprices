package com.example.commodityprices.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.commodityprices.R;
import com.example.commodityprices.ui.entities.Commodity;

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

        View view = (View) LayoutInflater.from(context).inflate(R.layout.text_view_layout,
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
        viewHolder.description.setText(commodity.getDescription());
    }

    @Override
    public int getItemCount() {
        return commodities.size();
    }

    public static class CommodityViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        RelativeLayout rootView;


        public CommodityViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            rootView = itemView.findViewById(R.id.root_view);
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
