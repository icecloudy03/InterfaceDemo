package com.ts.interfacedemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] title = new String[]{"1","2"};

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SimpleFragmentPagerAdapter(FragmentManager supportFragmentManager, Context context) {
        super(supportFragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
