package com.fullstackoasis.multislots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBeverages;
    private RecyclerView rvFruits;
    private ImageAdapter imageAdapterFruits;
    private ImageAdapter imageAdapterBeverages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvBeverages = (RecyclerView) findViewById(R.id.rv_beverage);
        List<ImageItem> imageItems = new ArrayList<ImageItem>();
        fill(imageItems);
        imageAdapterBeverages = new ImageAdapter(imageItems);
        rvBeverages.setAdapter(imageAdapterBeverages);
        /*
        imageAdapterFruits = new ImageAdapter(imageItems);
        rvFruits = (RecyclerView) findViewById(R.id.rv_fruit);
        rvFruits.setAdapter(imageAdapterFruits);
         */
    }

    private void fill(List<ImageItem> imageItems) {
        imageItems.add(createItem(R.drawable.ic_baseline_ac_unit_24));
        imageItems.add(createItem(R.drawable.ic_baseline_accessibility_24));
        imageItems.add(createItem(R.drawable.ic_baseline_restaurant_menu_24));
    }

    private ImageItem createItem(int resourceId) {
        ImageItem item = new ImageItem();
        item.setResourceId(resourceId);
        item.setDrawable(getDrawable(resourceId));
        return item;
    }
}