package com.lts.movie.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lts on 2017/8/29.
 * Fuction: fragment的基类,建议所有fragment都继承此类
 * Update:
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    public T mPresenter;
    public Activity mActivity;
    private boolean mIsStop;
    private View mFragmentRootView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentRootView = inflater.inflate(bindingLayou(), container, false);
        initView(mFragmentRootView);

        return mFragmentRootView;
    }

    public abstract @LayoutRes int bindingLayou();

    public abstract void initView(View view);

    @Override
    public void onStop() {
        super.onStop();
        mIsStop = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        mIsStop = false;
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ViewGroup parent = (ViewGroup) mFragmentRootView.getParent();
        if (null != parent) {
            parent.removeView(mFragmentRootView);
        }
    }
}
