package com.akmthecoder.foodiemart.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.akmthecoder.foodiemart.R;
import com.google.android.material.tabs.TabLayout;

public class FoodItemActivity extends AppCompatActivity {
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);
        tabLayout = findViewById(R.id.tbl_food_item);
        setTabLayout();
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Ingradients"));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
    }
}