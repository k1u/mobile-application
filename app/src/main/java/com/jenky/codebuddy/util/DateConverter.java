package com.jenky.codebuddy.util;

import android.widget.Toast;

import com.jenky.codebuddy.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Jason on 26-Apr-16.
 */
public class DateConverter {
    public String ddMMyyyyToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }

    public Date stringToddMMYYYY(String string) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal.getTime();
    }
}
