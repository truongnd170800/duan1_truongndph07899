package com.example.duan1_truongndph07899;

import android.graphics.Rect;

public interface LayoutModel {
    /**
     * called when the parent view size changes
     */
    public void onSizeChanged(int width, int height, int oldw, int oldh);

    /**
     * called for each child (by index) to get a layout Rect
     */
    public Rect getLayoutRect(int pos, int selected);
}
