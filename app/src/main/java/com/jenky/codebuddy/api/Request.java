package com.jenky.codebuddy.api;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.util.AppController;
import com.android.volley.Request.Method;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTLie on 31-5-2016.
 */
public class Request {
    public static final String API = "Https://Codebuddyjenky.herokuapp.com/";
    static ProgressBar progressBar;

    private Request(ProgressBar progressBar) {
        Request.progressBar = progressBar;
    }

    public static void executeRequest(int methodId, String url, final Callback callback, final Map<String, String> extraHeaders) {
        //Expect response in json format
        final String tag = "json_obj_req";
        Log.i("Request", methodId + ": " + url);
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(methodId, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getInt("responseCode") == 200) {
                                callback.onSuccess(response);
                            }else {
                                callback.onFailed(response);
                            }
                        } catch (JSONException e) {
                            Toast.makeText(AppController.getInstance(), R.string.default_error, Toast.LENGTH_SHORT).show();
                            Log.e("JSONException", e.getMessage(), e);
                        }
                        if (progressBar != null) {
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("HttpError", "Error: " + error.getMessage());
                Toast.makeText(AppController.getInstance(), R.string.default_error, Toast.LENGTH_SHORT).show();
                if (progressBar != null) {
                    progressBar.setVisibility(View.INVISIBLE);
                }
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
                API + "login",
                callback,
                credentials);
    }

    public  void getProfile(Callback callback) {
        executeRequest(Method.GET,
                API + "profile",
                callback,
                null);
    }

    public  void getSignUp(Callback callback, String email) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        executeRequest(Method.POST,
                API + "signup",
                callback,
                credentials);
    }

    public static void setVerify(Callback callback, String code, String password) {
        Map<String, String> verification = new HashMap<>();
        verification.put("verificationcode", code);
        verification.put("password", password);
        executeRequest(Method.POST,
                API + "signup/verify",
                callback,
                verification);
    }

    public static void getAchievements(Callback callback) {
        executeRequest(Method.GET,
                API +"achievements",
                callback,
                null);
    }

    public static void getTowers(Callback callback, int projectId) {
        executeRequest(Method.GET,
                API +"project/"+projectId,
                callback,
                null);
    }

    public static void getPurchase(Callback callback, int itemId) {
        executeRequest(Method.GET,
                API +"shop/buy/"+itemId,
                callback,
                null);
    }

    public static void getShop(Callback callback) {
        executeRequest(Method.GET,
                API +"shop",
                callback,
                null);
    }

    public static void getEquipment(Callback callback) {
        executeRequest(Method.GET,
                API +"equipment",
                callback,
                null);
    }

    public static void setEquipment(Callback callback, String headId, String shirtId, String legsId, String blockId) {
        executeRequest(Method.GET,
                API +"equipment/equip?head="+headId+"&"+"shirt="+shirtId+"&"+"legs="+legsId+"&"+"block="+blockId,
                callback,
                null);
    }

    public static Request getRequest(ProgressBar progressBar){
        return new Request(progressBar);
    }
}
