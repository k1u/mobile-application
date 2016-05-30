package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jason on 19-May-16.
 */
public class Preferences {
    public static final String sessionToken = "api_token";
    public SharedPreferences preferences;

    public static void logOut(Context context) {
        Intent intent = IntentFactory.getLogInIntent(context);
        context.startActivity(intent);
        //TODO delete sessionToken
    }

    public Preferences(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }


    public void setToken(String token) {
        preferences.edit().putString(sessionToken, token).apply();
    }

    public String getToken() {
        String token;
        token = preferences.getString(sessionToken, "");
        return token;
    }

    public void reset() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public Boolean hasCredentials() {
        return (AppContext.instance().getPreferences().getToken() == null || AppContext.instance().getPreferences().getToken().equals(""));
    }
}


