package com.jenky.codebuddy.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.ui.fragments.AchievementFragment;
import com.jenky.codebuddy.ui.fragments.ProfileFragment;
import com.jenky.codebuddy.ui.fragments.ProjectFragment;
import com.jenky.codebuddy.util.Converters;
import com.jenky.codebuddy.util.IntentFactory;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;
    private LinearLayout nvHeader;
    private TextView username;
    private RelativeLayout avatar;
    private ImageView head;
    private ImageView shirt;
    private ImageView legs;
    private final Converters converters = new Converters(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setSupportActionBar(toolbar);
        setDefaultValues();
        selectDefaultDrawerItem();
        setTestAvater();
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
        }
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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

    public void selectDrawerItem(MenuItem menuItem) {
        Class fragmentClass = null;
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
            }
            setFragment(fragmentClass);
        }
        menuItem.setChecked(true);
    }

    public void selectDefaultDrawerItem() {
        setFragment(ProfileFragment.class);
        nvDrawer.getMenu().getItem(0).setChecked(true);
        setTitle(R.string.profile);
    }

    public void setFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        drawer.closeDrawers();
    }

    public void goToShop() {
        Intent intent = IntentFactory.getShopIntent(this);
        startActivity(intent);
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        drawer.addDrawerListener(drawerToggle);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        nvHeader = (LinearLayout) nvDrawer.getHeaderView(0);
        username = (TextView) nvHeader.findViewById(R.id.username);
        avatar = (RelativeLayout) nvHeader.findViewById(R.id.avatar);
        setupDrawerContent(nvDrawer);
    }

    private void setDefaultValues() {
        username.setText("JTLie");
    }

    private void setTestAvater() {
        head = new ImageView(this);
        shirt = new ImageView(this);
        legs = new ImageView(this);
        head.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.test_head2));
        shirt.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.test_shirt2));
        legs.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.test_legs2));
        head.setLayoutParams(getHeadParams());
        shirt.setLayoutParams(getShirtParams());
        legs.setLayoutParams(getLegsParams());
        avatar.addView(head);
        avatar.addView(shirt);
        avatar.addView(legs);
    }

    private RelativeLayout.LayoutParams getHeadParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(4),
                0,
                0,
                0
        );
        return params;
    }

    private RelativeLayout.LayoutParams getShirtParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                0,
                converters.getInDp(36),
                0,
                0
        );
        return params;
    }

    private RelativeLayout.LayoutParams getLegsParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(11),
                converters.getInDp(67),
                0,
                0
        );
        return params;
    }
}


