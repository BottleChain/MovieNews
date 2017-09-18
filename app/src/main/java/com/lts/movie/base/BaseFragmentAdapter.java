package com.lts.movie.base;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    public BaseFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments,List<String> titles) {
        super(fm);
        this.mFragmentManager = fm;
        this.mFragments = fragments;
        this.mTitles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0:mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {

    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
