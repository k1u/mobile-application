package com.jenky.codebuddy.util;

/**
 * Created by JTLie on 31-5-2016.
 */

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    private static Context context;
    private Preferences preferences;

    public static final String TAG = AppController.class
            .getSimpleName();

    private RequestQueue requestQueue;



    public static AppController getInstance() {
        return (AppController) context;
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

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }

}

