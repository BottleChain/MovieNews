package com.lts.movie.castdetail.ui;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.bean.Cast;
import com.lts.movie.castdetail.CastPageAdapter;
import com.lts.movie.castdetail.presenter.CastDetailPresenter;
import com.lts.movie.castdetail.presenter.CastDetailPresenterImpl;
import com.lts.movie.castdetail.view.CastDetailView;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class CastDetailActivity extends BaseActivity<CastDetailPresenter> implements CastDetailView {


    private CircleImageView mCastIcon;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private int mCAST_id;
    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingView() {
        return R.layout.activity_cast_detail;
    }

    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public void initView() {
        mCAST_id = getIntent().getIntExtra(Constant.CAST_ID,-1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mCastIcon = (CircleImageView) findViewById(R.id.castIcon);
        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.material_white));
        mToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.material_white));
        mPresenter = new CastDetailPresenterImpl(this, mCAST_id);

    }

    private void initViewpage(Cast cast) {

        String[] stringArray = getResources().getStringArray(R.array.cast_info_tab);
        BaseFragment [] fragments = {CastBioFragment.newIntences(cast),CastAsActorFragment.newIntences(mCAST_id)};

        CastPageAdapter adapter = new CastPageAdapter(getSupportFragmentManager(),
                stringArray, fragments);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void showCastDetail(Cast cast, String msg, DataLoadType dataLoadType) {
        Picasso.with(this).load(Constant.logUrl + cast.getProfile_path()).into(mCastIcon);
        mToolbarLayout.setTitle(cast.getName());

        initViewpage(cast);
    }
}
