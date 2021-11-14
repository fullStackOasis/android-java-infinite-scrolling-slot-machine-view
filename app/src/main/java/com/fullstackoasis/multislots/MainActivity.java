package com.fullstackoasis.multislots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLeft;
    private RecyclerView rvRight;
    private ImageAdapter imageAdapterTwo;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the beverages.
        rvLeft = (RecyclerView) findViewById(R.id.rv_left);
        List<ImageItem> imageItems = new ArrayList<ImageItem>();
        fill(imageItems);
        imageAdapter = new ImageAdapter(imageItems);
        rvLeft.setAdapter(imageAdapter);

        // Set up the fruits.
        List<ImageItem> imageItemsTwo = new ArrayList<ImageItem>();
        fillTwo(imageItemsTwo);
        imageAdapterTwo = new ImageAdapter(imageItemsTwo);
        rvRight = (RecyclerView) findViewById(R.id.rv_right);
        rvRight.setAdapter(imageAdapterTwo);
    }

    private void fill(List<ImageItem> imageItems) {
        imageItems.add(createItem(R.drawable.ic_baseline_ac_unit_24));
        imageItems.add(createItem(R.drawable.ic_baseline_accessibility_24));
        imageItems.add(createItem(R.drawable.ic_baseline_restaurant_menu_24));
    }

    private void fillTwo(List<ImageItem> imageItems) {
        imageItems.add(createItem(R.drawable.ic_baseline_single_bed_24));
        imageItems.add(createItem(R.drawable.ic_baseline_work_24));
        imageItems.add(createItem(R.drawable.ic_baseline_create_24));
    }

    private ImageItem createItem(int resourceId) {
        ImageItem item = new ImageItem();
        item.setResourceId(resourceId);
        item.setDrawable(getDrawable(resourceId));
        return item;
    }
}