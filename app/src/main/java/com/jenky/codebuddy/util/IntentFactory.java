package com.jenky.codebuddy.util;

import android.content.Context;
import android.content.Intent;

import com.jenky.codebuddy.ui.MainActivity;

/**
 * Created by Jason on 14-Apr-16.
 */
public class IntentFactory {

    public static Intent getMainIntent(Context context) {
                 Intent intent = new Intent(context, MainActivity.class);
                 return intent;
           }

}
