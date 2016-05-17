package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jenky.codebuddy.ui.fragments.HelmetFragment;
import com.jenky.codebuddy.ui.fragments.LegsFragment;
import com.jenky.codebuddy.ui.fragments.ShirtFragment;

/**
 * Created by Jason on 12-May-16.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    final int pageCount = 3;
    private String tabTitles[] = new String[] { "Helmets", "Shirts", "Legs" };
    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return HelmetFragment.newInstance();
            case 1:
                return ShirtFragment.newInstance();
            case 2:
                return LegsFragment.newInstance();
            default:
                return HelmetFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
