package com.lts.movie.tv;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;

/**
 * Created by lts on 2017/9/4.
 * Fuction:
 * Update:
 */

public class TVActivity extends BaseActivity {


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingView() {
        return R.layout.activity_tv_layout;
    }

    @Override
    public boolean isHasNavigationView() {
        return true;
    }

    @Override
    public void initView() {
        mMenuDefaultCheckedItem = R.id.action_tv;
    }
}
