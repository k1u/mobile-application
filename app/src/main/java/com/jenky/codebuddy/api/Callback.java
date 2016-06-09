package com.jenky.codebuddy.api;


import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jenky.codebuddy.util.AppController;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by JTLie on 31-5-2016.
 */
public abstract class Callback {
    public abstract void onSuccess(JSONObject result) throws JSONException;


    public abstract  void onFailed(JSONObject result) throws JSONException;
}
