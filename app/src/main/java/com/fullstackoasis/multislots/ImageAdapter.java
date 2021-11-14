/**
 * (c) Marya Doery
 * Full Stack Oasis Consulting
 */
package com.fullstackoasis.multislots;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter {
    private final static String TAG = ImageAdapter.class.getCanonicalName();

    private final List<ImageItem> imageItems;

    public ImageAdapter(List<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivItem = (ImageView) itemView.findViewById(R.id.iv_item);
        }
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slot_item, parent, false);
        final ImageViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder rvHolder, int position) {
        ImageViewHolder ivHolder = (ImageViewHolder) rvHolder;
        // Compute a position that is limited between 0 and imageItems.size()
        int restrictedPosition = position % imageItems.size();
        Log.d(TAG, "restrictedPosition " + restrictedPosition);
        ImageItem imageItem = imageItems.get(restrictedPosition);
        ivHolder.ivItem.setImageDrawable(imageItem.getDrawable());
        ivHolder.ivItem.getLayoutParams().height = 400;
        ivHolder.ivItem.getLayoutParams().width = 400;
    }

    /**
     * Make this RecyclerView infinitely loop...
     * https://stackoverflow.com/questions/31253555/how-do-i-create-a-circular-endless-recyclerview
     * The only problem I see here is if the user is so patient that they keep scrolling up
     * to MAX_VALUE. In which case... hm!
     *
     * @return Integer.MAX_VALUE in order to simulate an infinitely looping scrolling view.
     */
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

}