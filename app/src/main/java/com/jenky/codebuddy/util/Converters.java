package com.jenky.codebuddy.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import com.jenky.codebuddy.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Jason on 26-Apr-16.
 */
public class Converters {

    Context context;

    public Converters(Context Context) {
        this.context = Context;
    }

    public static String ddMMyyyyToString(Calendar calendar) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(calendar.getTime());
    }

    public static Calendar stringToddMMYYYY(String string) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(string));
        } catch (Exception e) {
            e.printStackTrace();
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
