package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenter;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public interface MovieListPresenter extends BasePresenter{

    void reFreshData();

    void loadMoreData();
}
