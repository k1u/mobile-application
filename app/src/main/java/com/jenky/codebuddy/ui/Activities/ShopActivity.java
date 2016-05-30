package com.jenky.codebuddy.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ShopAdapter;
import com.jenky.codebuddy.util.Preferences;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private Button logOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setTitle(getString(R.string.shop));
        setViews();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTabs();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (Button) findViewById(R.id.log_out);
    }

    private void setTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ShopAdapter(getSupportFragmentManager(),
                ShopActivity.this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.log_out:
                Preferences.logOut(ShopActivity.this);
                finish();
                break;
            default:
                Log.e("onClick", getString(R.string.unknown_id));
                break;
        }
    }
}
