package com.jenky.codebuddy.api;


import com.android.volley.VolleyError;
import org.json.JSONObject;


/**
 * Created by JTLie on 31-5-2016.
 */
public interface Callback {
    void onSuccess(JSONObject result);
    void onFailed(VolleyError error);
}
