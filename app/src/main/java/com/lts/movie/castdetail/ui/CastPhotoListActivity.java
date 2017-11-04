package com.lts.movie.castdetail.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created Date:  2017/9/29.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class CastPhotoListActivity extends BaseActivity {


    private ViewPager mViewPager;
    private CircleIndicator mIndicator;

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingView() {
        return R.layout.activity_cast_photo_list;
    }

    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mIndicator = (CircleIndicator) findViewById(R.id.indicator);
//        mIndicator.setViewPager(mViewPager);
        initViewPage();
    }

    private void initViewPage() {

        ArrayList<String> arrayList = getIntent().getStringArrayListExtra(Constant.CAST_PHOTO_LIST);
        int position = getIntent().getIntExtra(Constant.POSITION, -1);

        PhotoAdapter adapter = new PhotoAdapter(getSupportFragmentManager(), arrayList);
        mViewPager.setAdapter(adapter);
        adapter.registerDataSetObserver(mIndicator.getDataSetObserver());
        mViewPager.setCurrentItem(position);

    }

    private class PhotoAdapter extends FragmentPagerAdapter {
        private List<String> mImagePath;

        public PhotoAdapter(FragmentManager fm,List<String> imagePath) {
            super(fm);
            this.mImagePath = imagePath;
        }

        @Override
        public Fragment getItem(int position) {
            return PhotoFragment.newIntences(mImagePath.get(position));
        }

        @Override
        public int getCount() {
            return mImagePath.size();
        }
    }

}
