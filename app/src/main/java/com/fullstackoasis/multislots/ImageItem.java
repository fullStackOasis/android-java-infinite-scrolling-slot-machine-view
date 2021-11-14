package com.fullstackoasis.multislots;

import android.graphics.drawable.Drawable;

public class ImageItem {
    /**
     * Represents a drawable resource id.
     */
    private int resourceId;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    private Drawable drawable;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

}
