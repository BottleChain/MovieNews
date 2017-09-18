package com.lts.movie.movie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lts.movie.base.BaseFragment;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */

public class MovieFragmentAdapter extends FragmentPagerAdapter {


    private final String[] mStringArray;
    private BaseFragment [] mFragments;

    public MovieFragmentAdapter(FragmentManager fm,BaseFragment [] fragments , String [] tabs) {
        super(fm);
       this.mStringArray = tabs;
       this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStringArray[position];
    }

    @Override
    public int getCount() {
        return mStringArray.length;
    }
}
