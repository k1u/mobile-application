package com.jenky.codebuddy.api;

import com.android.volley.VolleyError;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Preferences;

import org.json.JSONObject;

/**
 * Created by JTLie on 31-5-2016.
 */
public abstract class Callback {
    public abstract void onSuccess(JSONObject result);
    public abstract void onFailed(VolleyError error);
    public void onFailedUnauthorized(){
        Preferences.logOut(AppController.getInstance());
    }
}
