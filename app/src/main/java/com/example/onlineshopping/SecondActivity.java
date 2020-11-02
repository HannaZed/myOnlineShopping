package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.onlineshopping.adapter.CategoryAdapter;
import com.example.onlineshopping.adapter.DiscountedProductAdapter;
import com.example.onlineshopping.model.AllCategoryModel;
import com.example.onlineshopping.model.DiscountedProducts;
import com.example.onlineshopping.model.Category;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    RecyclerView discount_recycler_view,categoryRecyclerView;
    DiscountedProductAdapter discountedProductAdapter;
    ArrayList<DiscountedProducts> discountedProductsList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    ImageView mallCategoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        discount_recycler_view=findViewById(R.id.recyclerView_discounted);
        categoryRecyclerView=findViewById(R.id.categoryRecycler);
        mallCategoryImage=findViewById(R.id.all_category_image);

        mallCategoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, AllCategoryActivity.class));
            }
        });

        //adding data to model

        discountedProductsList=new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.white_beans));
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.mchele_ulionyooka));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.mahindi_lishe));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.brown_wheat));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.beans));

        categoryList=new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.vegetables));
        categoryList.add(new Category(2,R.drawable.tomatoes));
        categoryList.add(new Category(3,R.drawable.meat));
        categoryList.add(new Category(4,R.drawable.white_beans));
        setCategoryRecyclerView(categoryList);
        setDiscountRecyclerView(discountedProductsList);



    }

    private void setDiscountRecyclerView(List<DiscountedProducts> datalist) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discount_recycler_view.setLayoutManager(layoutManager);
        discountedProductAdapter =new DiscountedProductAdapter(this,datalist);
        discount_recycler_view.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecyclerView(List<Category> categorydatalist) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discount_recycler_view.setLayoutManager(layoutManager);
        categoryAdapter =new CategoryAdapter(this,categorydatalist);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
}