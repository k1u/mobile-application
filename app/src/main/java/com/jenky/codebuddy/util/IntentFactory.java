package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;

import com.jenky.codebuddy.ui.activities.LogInActivity;
import com.jenky.codebuddy.ui.activities.MainActivity;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import com.jenky.codebuddy.ui.activities.SignUpActivity;
import com.jenky.codebuddy.ui.activities.TowerActivity;

/**
 * Class which contains methods to receive different Intents
 */
public class IntentFactory {

    private IntentFactory(){
        //Prevent instantiation
    }

    public static Intent getMainIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    public static Intent getShopIntent(Context context) {
        return new Intent(context, ShopActivity.class);
    }

    public static Intent getTowerIntent(Context context) {
        return new Intent(context, TowerActivity.class);
    }

    public static Intent getLogInIntent(Context context) {
        return new Intent(context, LogInActivity.class);
    }

    public static Intent getSignUpIntent(Context context) {
        return new Intent(context, SignUpActivity.class);
    }
}
