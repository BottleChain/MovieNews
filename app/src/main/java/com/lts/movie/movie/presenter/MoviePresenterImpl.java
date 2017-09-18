package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.movie.moudel.MovieMoudelImpl;
import com.lts.movie.movie.view.MovieView;

import java.util.List;

/**
 * Created by lts on 2017/8/29.
 * Fuction:
 * Update:
 */

public class MoviePresenterImpl extends BasePresenterImpl<MovieView,List<String>> implements MoviePresenter{


    private final MovieMoudelImpl movieMoudel;

    public MoviePresenterImpl(MovieView view) {
        super(view);
        movieMoudel = new MovieMoudelImpl();
        mSubscription = movieMoudel.getMovieTabs(this);
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void loadMoreDate() {

    }

    @Override
    public void requestError(String msg) {
        mView.hideProgress();
    }

    @Override
    public void requestSuccess(List<String> data) {
        mView.initViewPage(data);
    }
}
