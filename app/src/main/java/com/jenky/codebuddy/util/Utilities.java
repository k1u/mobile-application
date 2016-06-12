package com.jenky.codebuddy.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Jason on 26-Apr-16.
 */
public class Utilities {

    private Utilities() {

    }

    public static String ddMMyyyyToString(Calendar calendar) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return df.format(calendar.getTime());
    }


    public static int getInDp(Context context, int value){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return Math.round(value * displayMetrics.density);
    }

    public static RelativeLayout.LayoutParams getLayoutParams(Context context, int width, int height, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(getInDp(context, width), getInDp(context, height));
        params.setMargins(
                getInDp(context, marginLeft),
                getInDp(context, marginTop),
                getInDp(context, marginRight),
                getInDp(context, marginBottom)
        );
        return params;
    }
}
