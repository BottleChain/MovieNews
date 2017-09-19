package com.lts.movie.search;

import android.view.Menu;
import android.widget.EditText;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;

/**
 * Created by lts on 2017/9/19.
 * Fuction:
 * Update:
 */

public class SearchActivity extends BaseActivity {




    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingView() {
        return R.layout.activity_search;
    }

    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_clear, menu);

        return true;
    }

    @Override
    public void initView() {

        EditText editText = (EditText) findViewById(R.id.search_view);


    }
}
