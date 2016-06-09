package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jason on 19-May-16.
 */
public class Preferences {
    public static final String SESSION_TOKEN = "token";
    public static final String USER_NAME = "user_name";
    private SharedPreferences sharedPreferences;

    public static void logOut(Context context) {
        Intent intent = IntentFactory.getLogInIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        AppController.getInstance().getPreferences().reset();
    }

    public Preferences(Context appContext) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }


    public void setToken(String token) {
        sharedPreferences.edit().putString(SESSION_TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(SESSION_TOKEN, "");
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
        return AppController.getInstance().getPreferences().getToken() == null || AppController.getInstance().getPreferences().getToken().equals("");
    }
}


