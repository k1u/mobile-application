package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.ui.fragments.ShopFragment;


/**
 * Created by Jason on 12-May-16.
 */
public class ShopAdapter extends FragmentPagerAdapter {
    static final int PAGE_COUNT = 4;
    private String[] tabTitles;
    public ShopAdapter(FragmentManager fm, Context context) {
            super(fm);

        this.tabTitles = new String[] {
                context.getString(R.string.helmets),
                context.getString(R.string.shirts),
                context.getString(R.string.legs),
                context.getString(R.string.blocks)
        };
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ShopFragment("helmet");
            case 1:
                return new ShopFragment("shirt");
            case 2:
                return new ShopFragment("legs");
            case 3:
                return new ShopFragment("block");
            default:
                return new ShopFragment("helmet");
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
