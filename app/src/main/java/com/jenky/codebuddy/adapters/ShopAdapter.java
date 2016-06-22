package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.ui.fragments.ShopFragment;


public class ShopAdapter extends FragmentPagerAdapter {
    static final int PAGE_COUNT = 4;
    private String[] tabTitles;
    private Context context;
    public ShopAdapter(FragmentManager fm, Context context) {
            super(fm);

        this.tabTitles = new String[] {
                context.getString(R.string.helmets) ,
                context.getString(R.string.shirts),
                context.getString(R.string.legs),
                context.getString(R.string.blocks)
        };
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
                Bundle args = new Bundle();
                args.putString("type", tabTitles[position]);
                Fragment fragment = new ShopFragment();
                fragment.setArguments(args);
                return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
