package com.jenky.codebuddy.custom;

/**
 * Created by JTLie on 20-5-2016.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class VerticalScroll extends ScrollView {

    public VerticalScroll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VerticalScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScroll(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
