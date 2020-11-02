package com.example.onlineshopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {

    Context context;
    List<DiscountedProducts> discountedProductsList;

    public DiscountedProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.discounted_newitem_layout,parent,false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {
        holder.discounted_image_view.setImageResource(discountedProductsList.get(position).getImageuri());

    }

    @Override
    public int getItemCount() {
        return discountedProductsList.size();
       // return 5;
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder{
        ImageView discounted_image_view;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            discounted_image_view=itemView.findViewById(R.id.discounted_image);
        }
    }
}
