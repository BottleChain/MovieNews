package com.lts.movie.castdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lts.movie.base.BaseFragment;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastPageAdapter extends FragmentPagerAdapter {

    private String [] mStringArray;
    private BaseFragment [] mFragment;

    public CastPageAdapter(FragmentManager fm,String[] arr,BaseFragment [] fragments) {
        super(fm);
        this.mStringArray = arr;
        this.mFragment = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragment[position];
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
