package com.jenky.codebuddy.ui.activities;

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
import android.view.MenuItem;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.ui.fragments.AchievementFragment;
import com.jenky.codebuddy.ui.fragments.ProfileFragment;
import com.jenky.codebuddy.ui.fragments.ProjectFragment;
import com.jenky.codebuddy.util.IntentFactory;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();
        selectDefaultDrawerItem();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle state) {
        super.onPostCreate(state);
        drawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
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

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Class fragmentClass;
        setTitle(menuItem.getTitle());
        switch(menuItem.getItemId()) {
            case R.id.profile:
                fragmentClass = ProfileFragment.class;
                break;
            case R.id.projects:
                fragmentClass = ProjectFragment.class;
                break;
            case R.id.achievements:
                fragmentClass = AchievementFragment.class;
                break;
            case R.id.shop:
                fragmentClass = ProfileFragment.class;
                setTitle(getString(R.string.profile));
                goToShop();
                break;
            default:
                fragmentClass = ProfileFragment.class;
        }
        setFragment(fragmentClass);
        menuItem.setChecked(true);
        // Set action bar title

        // Close the navigation drawer
    }

    public void selectDefaultDrawerItem() {
        setFragment(ProfileFragment.class);
        nvDrawer.getMenu().getItem(0).setChecked(true);
        setTitle(R.string.profile);
    }

    public void setFragment(Class fragmentClass){
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        mDrawer.closeDrawers();
    }

    public void goToShop(){
        Intent intent = IntentFactory.getShopIntent(this);
        startActivity(intent);
    }

    private void setActionBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
    }
}


