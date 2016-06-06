package com.jenky.codebuddy.api;

import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jenky.codebuddy.util.AppController;
import com.android.volley.Request.Method;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTLie on 31-5-2016.
 */
public class Request {

    private Request(){

    }

    public static final String api = "http://codebuddyjenky.azurewebsites.net/";
    public static void executeRequest(int methodId, String url, final Callback callback, final Map<String, String> extraHeaders) {
        //Expect response in json format
        final String tag = "json_obj_req";
        Log.i("Request", methodId + ": " + url);
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(methodId, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("HttpError", "Error: " + error.getMessage());
                Toast.makeText(AppController.getInstance(), "Something went wrong", Toast.LENGTH_SHORT).show();
                callback.onFailed(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (extraHeaders != null) {
                    headers.putAll(extraHeaders);
                }
                headers.put("token", AppController.getInstance().getPreferences().getToken());
                return headers;
            }
        };
        jsonObjReq.setRetryPolicy(new
                        DefaultRetryPolicy(
                        0,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        );
        AppController.getInstance().

                addToRequestQueue(jsonObjReq, tag);
    }

    public static void getLogIn(Callback callback, String email, String password) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);
        executeRequest(Method.POST,
                api + "login",
                callback,
                credentials);
    }

    public static void getPlayer(Callback callback) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api + "tokentest",
                callback,
                null);
    }

    public static void getHistory(Callback callback) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void getSignUp(Callback callback, String email) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        //TODO replace URL with real URL
        executeRequest(Method.POST,
                api + "signup",
                callback,
                credentials);
    }

    public static void setVerify(Callback callback, String code, String password) {
        Map<String, String> verification = new HashMap<>();
        verification.put("verificationcode", code);
        verification.put("password", password);
        //TODO replace URL with real URL
        executeRequest(Method.POST,
                api + "verify",
                callback,
                verification);
    }

    public static void getAchievements(Callback callback) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void getTower(Callback callback, int projectId) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void getPurchase(Callback callback, int itemId) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void getShop(Callback callback) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void getEquipment(Callback callback) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }

    public static void setEquipment(Callback callback, String headId, String shirtId, String legsId, String blockId) {
        //TODO replace URL with real URL
        executeRequest(Method.GET,
                api,
                callback,
                null);
    }
}
