package com.jenky.codebuddy.api;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by JTLie on 31-5-2016.
 */
public interface Callback {
    void onSuccess(JSONObject result) throws JSONException;
    void onFailed(JSONObject result) throws JSONException;
}
