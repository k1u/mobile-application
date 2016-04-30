package com.jenky.codebuddy.ui;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;

import com.jenky.codebuddy.R;

public class TowerActivity extends Activity {

    LinearLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower);
        main = (LinearLayout) findViewById(R.id.main);

    }
}
