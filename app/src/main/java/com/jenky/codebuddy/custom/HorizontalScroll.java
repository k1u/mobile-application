package com.jenky.codebuddy.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class HorizontalScroll extends HorizontalScrollView {

    public HorizontalScroll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HorizontalScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalScroll(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}