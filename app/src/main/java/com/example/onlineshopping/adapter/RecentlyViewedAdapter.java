package com.example.onlineshopping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.model.DiscountedProducts;
import com.example.onlineshopping.model.RecentlyViewed;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewHolder> {
    Context context;
    List<RecentlyViewed> recentlyViewedList;
    @NonNull
    @Override
    public RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewHolder extends RecyclerView.ViewHolder{

        public RecentlyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
