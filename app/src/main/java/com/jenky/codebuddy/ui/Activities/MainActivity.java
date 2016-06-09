package com.jenky.codebuddy.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.ui.fragments.AchievementFragment;
import com.jenky.codebuddy.ui.fragments.ProfileFragment;
import com.jenky.codebuddy.ui.fragments.ProjectFragment;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Converters;
import com.jenky.codebuddy.util.IntentFactory;

import com.jenky.codebuddy.util.Preferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;
    private LinearLayout nvHeader;
    private TextView usernameTextView;
    private Button logOut;
    private final Converters converters = new Converters(this);
    private String username;
    private ProgressBar progressBar;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setSupportActionBar(toolbar);
        setValues();
        selectDefaultDrawerItem();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
            default:
                return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onPostCreate(Bundle state) {
        super.onPostCreate(state);
        drawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        Class fragmentClass;
        if (menuItem.getItemId() == R.id.shop) {
            goToShop();
        } else {
            setTitle(menuItem.getTitle());
            switch (menuItem.getItemId()) {
                case R.id.profile:
                    fragmentClass = ProfileFragment.class;
                    break;
                case R.id.projects:
                    fragmentClass = ProjectFragment.class;
                    break;
                case R.id.achievements:
                    fragmentClass = AchievementFragment.class;
                    break;
                default:
                    fragmentClass = ProfileFragment.class;
                    break;
            }
            setFragment(fragmentClass);
        }
        menuItem.setChecked(true);
    }

    private void selectDefaultDrawerItem() {
        setFragment(ProfileFragment.class);
        nvDrawer.getMenu().getItem(0).setChecked(true);
        setTitle(R.string.profile);
    }

    private void setFragment(Class fragmentClass) {
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
            drawer.closeDrawers();
        } catch (Exception e) {
            Log.e("SetFragment", e.toString());
        }
    }

    private void goToShop() {
        Intent intent = IntentFactory.getShopIntent(this);
        startActivity(intent);
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (Button) findViewById(R.id.log_out);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        drawer.addDrawerListener(drawerToggle);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        nvHeader = (LinearLayout) nvDrawer.getHeaderView(0);
        usernameTextView = (TextView) nvHeader.findViewById(R.id.email);
        setupDrawerContent(nvDrawer);
        logOut.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    private void setValues() {
        username =  AppController.getInstance().getPreferences().getUserName();
        usernameTextView.setText(username);
    }


    private RelativeLayout.LayoutParams getParams(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(marginLeft),
                converters.getInDp(marginTop),
                converters.getInDp(marginRight),
                converters.getInDp(marginBottom)
        );
        return params;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.log_out:
                Preferences.logOut(MainActivity.this);
                finish();
                break;
            default:
                Log.e("onClick", getString(R.string.unknown_id));
                break;
        }
    }



}


