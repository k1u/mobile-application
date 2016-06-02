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

    public static final String api = "http://codebuddyjenky.azure.net/";

    public static void executeRequest(String method, String url, final Callback callback) {
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
                if (error.networkResponse != null) {
                    switch (error.networkResponse.statusCode) {
                        case 401:
                            callback.onFailedUnauthorized();
                            break;
                        default:
                            callback.onFailed(error);
                    }
                }
            }
        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return AppController.getInstance().getPreferences().getToken();
            }
        };
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public static void getLogIn(Callback callback, String email, String password) {
        //TODO replace URL with real URL
        executeRequest("post",
                api + "login?email=" + email + "&password=" + password,
                callback);
    }

    public static void getPlayer(Callback callback) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }

    public static void getHistory(Callback callback) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }

    public static void getSignUp(Callback callback, String email) {
        //TODO replace URL with real URL
        executeRequest("post",
                api,
                callback);
    }

    public static void getAchievements(Callback callback) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }

    public static void getTower(Callback callback, int projectId) {
        //TODO replace URL with real URL
        executeRequest("post",
                api,
                callback);
    }

    public static void getPurchase(Callback callback, int itemId) {
        //TODO replace URL with real URL
        executeRequest("post",
                api,
                callback);
    }

    public static void getShop(Callback callback) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }

    public static void getEquipment(Callback callback) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }

    public static void setEquipment(Callback callback, String headId, String shirtId, String legsId, String BlockId) {
        //TODO replace URL with real URL
        executeRequest("get",
                api,
                callback);
    }
}
