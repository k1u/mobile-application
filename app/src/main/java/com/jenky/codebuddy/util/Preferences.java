package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason on 19-May-16.
 */
public class Preferences {
    public static final String serverUrl = "https://jenky.azurewebsites.net/";
    public static final String sessionToken = "api_token";
    public SharedPreferences preferences;

    public static void logOut(Context context) {
        Intent intent = IntentFactory.getLogInIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        //TODO delete sessionToken
    }

    public Preferences(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }


    public void setToken(String token) {
        preferences.edit().putString(sessionToken, token).apply();
    }

    public Map<String,String> getToken() {
        Map<String, String> token = new HashMap<>();
        token.put("token", sessionToken);
        return token;
    }

    public static String getServerUrl() {
        return serverUrl;
    }

    public void reset() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public Boolean hasCredentials() {
        return (AppController.getInstance().getPreferences().getToken() == null || AppController.getInstance().getPreferences().getToken().equals(""));
    }
}


