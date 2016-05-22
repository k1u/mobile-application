package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;

import com.jenky.codebuddy.ui.activities.MainActivity;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import com.jenky.codebuddy.ui.activities.TowerActivity;

/**
 * Created by Jason on 14-Apr-16.
 */
public class IntentFactory {

    public static Intent getMainIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    public static Intent getShopIntent(Context context) {
        Intent intent = new Intent(context, ShopActivity.class);
        return intent;
    }

    public static Intent getTowerIntent(Context context) {
        Intent intent = new Intent(context, TowerActivity.class);
        return intent;
    }
}
