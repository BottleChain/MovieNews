package com.lts.movie.castdetail.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.constant.Constant;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastAsActorFragment extends BaseFragment {


    private int mPersonId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mPersonId = getArguments().getInt(Constant.CAST_ID);
        }
    }

    public static CastAsActorFragment newIntences(int person_id) {
        CastAsActorFragment fragment = new CastAsActorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.CAST_ID, person_id);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_cast_as_actor;
    }

    @Override
    public void initView(View view) {

    }
}
