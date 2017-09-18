package com.lts.movie.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.lts.movie.BuildConfig;
import com.lts.movie.R;
import com.lts.movie.movie.ui.MainActivity;
import com.lts.movie.setting.SettingActivity;
import com.lts.movie.tv.TVActivity;

/**
 * Created by lts on 2017/8/28.
 * Fuction:Activity的基类,
 * Update:
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView,View.OnClickListener{

    protected T mPresenter;
    protected Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Class mClass;
    protected int mMenuDefaultCheckedItem;
    protected String mToolbarTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }

        setContentView(bindingView());

        initView();
        initToolbar();

        if (isHasNavigationView()) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            initNavigationView();
        }
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (mNavigationView != null) {
            mNavigationView.setCheckedItem(mMenuDefaultCheckedItem);
        }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) {
                    return true;
                }

                switch (item.getItemId()) {
                    case R.id.action_movie:
                        mClass = MainActivity.class;
                        break;
                    case R.id.action_tv:
                        mClass = TVActivity.class;
                        break;
                    case R.id.action_setting:
                        mClass = SettingActivity.class;
                        break;
                }

                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                if (mClass != null) {
                    Intent intent = new Intent(BaseActivity.this, mClass);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    mClass = null;
                }
            }
        });

    }


    void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                if (isHasNavigationView()) {
                    getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_list_white);
                }
            }

        }

    }

    public abstract int bindingView();

    public abstract boolean isHasNavigationView();

    public abstract void initView();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isHasNavigationView() && item.getItemId() == android.R.id.home) {

            mDrawerLayout.openDrawer(GravityCompat.START);
        } else if (item.getItemId() == android.R.id.home && mToolbar != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return  true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }




    @Override
    public void onClick(View v) {

    }
}
