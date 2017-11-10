package com.lts.movie.movie.ui;

import android.Manifest;
import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.constant.Constant;
import com.lts.movie.movie.MovieFragmentAdapter;
import com.lts.movie.movie.presenter.MovieDeatilPresenterImpl;
import com.lts.movie.movie.presenter.MovieDetailPresenter;
import com.lts.movie.movie.view.MovieDeatilView;
import com.lts.movie.util.PicassoUtil;
import com.lts.movie.widget.AppBarStateChangeListener;
import com.socks.library.KLog;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by lts on 2017/9/3.
 * Fuction:影片详情页面
 * Update:
 */

@RuntimePermissions
public class MovieDetailActivity extends BaseActivity<MovieDetailPresenter> implements MovieDeatilView {


    private ImageView mMovieBackgound;
    private ImageView mMovieLogo;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton mFab;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mMovieName;
    private TextView mMovieType;
    private String mTitle;
    private int mMovieId;
    private UMImage mImage;
    private UMWeb mWeb;

    @Override
    public int bindingView() {
        return R.layout.activity_movie_detail;
    }


    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public void initView() {
        initActionBoutton();
        mMovieBackgound = (ImageView) findViewById(R.id.movie_background_photo);
        mMovieLogo = (ImageView) findViewById(R.id.movie_logo);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mMovieName = (TextView) findViewById(R.id.movie_name);
        mMovieType = (TextView) findViewById(R.id.movie_type);
        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
        mToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.material_white));

        mMovieId = getIntent().getIntExtra(Constant.movie_id, -1);
        initViewPag();

        mPresenter = new MovieDeatilPresenterImpl(this, mMovieId);
    }


    private void initViewPag() {
        String[] stringArray = getResources().getStringArray(R.array.movie_info_tab);
        BaseFragment[] fragments = {MovieOverViewFragment.newIntences(mMovieId), CastFragment.newIntences(mMovieId), ReviewFragment.newIntences(mMovieId)};

        MovieFragmentAdapter adapter = new MovieFragmentAdapter(getSupportFragmentManager(),fragments,stringArray);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initActionBoutton() {
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        AppBarLayout appbar = (AppBarLayout) findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {
                    mFab.show();
                    mToolbar.setTitle("");
                } else if (state == State.COLLAPSED) {
                    mToolbar.setTitle(mTitle);
                    mFab.hide();
                } else {
                    //中间状态
                    mFab.show();
                }

            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetailActivity.this, MoviePlayListActivity.class);
                intent.putExtra(Constant.movie_id, mMovieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_share, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            MovieDetailActivityPermissionsDispatcher.showShareWithCheck(this);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void showMovieDetail(MovieDetail movieDetail) {

        startCircularReveal();
        PicassoUtil.Intences(this).load(Constant.logUrl + movieDetail.getPoster_path()).into(mMovieLogo);
        PicassoUtil.Intences(this).load(Constant.backgoundUrl + movieDetail.getBackdrop_path()).resize(mMovieBackgound.getWidth()/2,mMovieBackgound.getHeight()/2).into(mMovieBackgound);
        mToolbarLayout.setTitle(movieDetail.getTitle());
        mMovieName.setText(movieDetail.getTitle());
        mMovieType.setText(getMovieType(movieDetail.getGenres()));

        //友盟分享的信息
        mImage = new UMImage(this, Constant.logUrl + movieDetail.getPoster_path());
        mTitle = movieDetail.getTitle();

        mWeb = new UMWeb("http://www.imdb.com/title/" + movieDetail.getImdb_id());
        mWeb.setTitle(movieDetail.getTitle());
        mWeb.setThumb(mImage);
        mWeb.setDescription(movieDetail.getOverview());

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startCircularReveal() {
        float finalRadius = (float) Math.hypot(mMovieBackgound.getWidth(), mMovieBackgound.getHeight());
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(mMovieBackgound, mMovieBackgound.getWidth() / 2, mMovieBackgound.getHeight(), 0, finalRadius);
        circularReveal.setDuration(800);
        circularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        circularReveal.start();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//
//        }
    }

    private String getMovieType(List<MovieDetail.GenresBean> genres) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < genres.size(); i++) {
            sb.append(genres.get(i).getName());
            if (i != genres.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            KLog.d("onstart");
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            KLog.d("onresult");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            KLog.d(throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            KLog.d("oncancel");
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @NeedsPermission(value = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void showShare() {
        new ShareAction(this)
                        .withMedia(mWeb)
                        .setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.QQ,SHARE_MEDIA.SINA,SHARE_MEDIA.QZONE)
                        .setCallback(shareListener)
                        .open();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MovieDetailActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getPermissionDenied() {

        Snackbar.make(mViewPager,"获取权限失败,请手动开启",Snackbar.LENGTH_LONG).show();
    }
}
