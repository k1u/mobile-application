package com.jenky.codebuddy.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Locale;

/**
 * Created by Jason on 26-Apr-16.
 */
public class Converters {

    private Context context;

    public Converters(Context context) {
        this.context = context;
    }

    public static String ddMMyyyyToString(Calendar calendar) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return df.format(calendar.getTime());
    }

    public static Calendar stringToddMMYYYY(String string) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(string));
        } catch (Exception e) {
            Log.e("Converters", e.toString());
        }
        return cal;
    }

    public int getInDp(int value){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return Math.round(value * displayMetrics.density);
    }
}
