package com.lts.movie.movie.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseFragmentAdapter;
import com.lts.movie.constant.MovieListType;
import com.lts.movie.movie.presenter.MoviePresenter;
import com.lts.movie.movie.presenter.MoviePresenterImpl;
import com.lts.movie.movie.view.MovieView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MoviePresenter> implements MovieView {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public void initView() {
        mMenuDefaultCheckedItem = R.id.action_movie;
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPresenter = new MoviePresenterImpl(this);
    }


    @Override
    public int bindingView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean isHasNavigationView() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_search,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initViewPage(List<String> movieListTypes) {
        List<BaseFragment> fragments = new ArrayList<>();

        MovieListType[] values = MovieListType.values();
        if (movieListTypes != null) {
            for (int i = 0; i < movieListTypes.size(); i++) {
                MovieListFragment fragment = MovieListFragment.newInstance(values[i]);
                fragments.add(fragment);
            }

            if (mViewPager.getAdapter() == null) {
                BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(),
                        fragments, movieListTypes);
                mViewPager.setAdapter(adapter);

            }

            mViewPager.setCurrentItem(0, false);
            mTabLayout.setScrollPosition(0,0,true);
            mTabLayout.setupWithViewPager(mViewPager);

        }
    }
}
