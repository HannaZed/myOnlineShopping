package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.onlineshopping.adapter.AllCategoryAdapter;
import com.example.onlineshopping.adapter.CategoryAdapter;
import com.example.onlineshopping.adapter.DiscountedProductAdapter;
import com.example.onlineshopping.model.AllCategoryModel;
import com.example.onlineshopping.model.DiscountedProducts;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity {
    RecyclerView allCategoryRecycler    ;
    List<AllCategoryModel> categoryModelList;
    AllCategoryAdapter allCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        allCategoryRecycler=findViewById(R.id.allCategory);
        categoryModelList.add(new AllCategoryModel(1,R.drawable.white_beans));
        categoryModelList.add(new AllCategoryModel(1,R.drawable.mchele_ulionyooka));
        categoryModelList.add(new AllCategoryModel(3,R.drawable.mahindi_lishe));
        categoryModelList.add(new AllCategoryModel(4,R.drawable.brown_wheat));
        categoryModelList.add(new AllCategoryModel(5,R.drawable.beans));
        allCategoryRecycler(categoryModelList);


    }
    private void allCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,1);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter =new AllCategoryAdapter(this,allCategoryModelList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }
}