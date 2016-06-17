package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;

import org.json.JSONException;
import org.json.JSONObject;

public class Preferences {
    public static final String SESSION_TOKEN = "session_token";
    public static final String MESSAGING_TOKEN = "messaging_token";
    public static final String USER_NAME = "user_name";
    private SharedPreferences sharedPreferences;

    public static final Callback messagingCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    public static final  Callback logOutCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
            AppController.getInstance().getPreferences().reset();
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    public static void logOut(Context context) {
        Intent intent = IntentFactory.getLogInIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        Request.deleteMessagingToken(logOutCallback);
    }

    public Preferences(Context appContext) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }


    public void setSessionToken(String token) {
        sharedPreferences.edit().putString(SESSION_TOKEN, token).apply();
    }

    public String getSessionToken() {
        return sharedPreferences.getString(SESSION_TOKEN, "");
    }


    public void setMessageToken(String token) {
        sharedPreferences.edit().putString(MESSAGING_TOKEN, token).apply();
    }

    public String getMessageToken() {
        return sharedPreferences.getString(MESSAGING_TOKEN, "");
    }


    public void setUserName(String mUserName) {
        sharedPreferences.edit().putString(USER_NAME, mUserName).apply();
    }



    public String getUserName() {
        return sharedPreferences.getString(USER_NAME, "");
    }



    public void reset() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public Boolean hasCredentials() {
        return AppController.getInstance().getPreferences().getSessionToken() == null || AppController.getInstance().getPreferences().getSessionToken().equals("");
    }
}


