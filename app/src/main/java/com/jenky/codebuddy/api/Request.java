package com.jenky.codebuddy.api;

import android.telecom.Call;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jenky.codebuddy.util.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTLie on 31-5-2016.
 */
public class Request {

    public static void executeRequest(String method, String url, final Map<String, String> headers, final Map<String, String> params, final Callback callback) {
        //Expect response in json format
        final String tag_json_obj = "json_obj_req";
        int methodId;
        switch (method) {
            case "get":
                methodId = 0;
                break;
            case "post":
                methodId = 1;
                break;
            case "put":
                methodId = 2;
                break;
            case "delete":
                methodId = 3;
                break;
            case "head":
                methodId = 4;
                break;
            case "options":
                methodId = 5;
                break;
            case "trace":
                methodId = 6;
                break;
            case "patch":
                methodId = 7;
                break;
            default:
                methodId = 0;
                break;
        }

        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(methodId,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("HttpError", "Error: " + error.getMessage());
                // hide the progress dialog
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }


    public static void getToken(Callback callback, String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        //TODO replace URL with real Log in URL
        executeRequest("get", "http://api.androidhive.info/volley/person_object.json", null, params, callback);
    }


}
