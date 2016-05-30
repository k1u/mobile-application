package com.jenky.codebuddy.util;

/**
 * Created by JTLie on 31-5-2016.
 */

import android.app.Application;
import android.content.Context;

public class AppContext extends Application {

    private static Context context;
    private Preferences preferences;

    public static AppContext instance() {
        return (AppContext) context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        preferences = new Preferences(context);
    }



    public Preferences getPreferences() {
        return preferences;
    }


}

