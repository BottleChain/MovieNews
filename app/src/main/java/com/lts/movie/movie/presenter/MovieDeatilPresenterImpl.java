package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.constant.Constant;
import com.lts.movie.movie.moudel.MovieDetailMoudel;
import com.lts.movie.movie.moudel.MovieDetailMoudelImpl;
import com.lts.movie.movie.view.MovieDeatilView;

/**
 * Created by lts on 2017/9/5.
 * Fuction:
 * Update:
 */

public class MovieDeatilPresenterImpl extends BasePresenterImpl<MovieDeatilView,MovieDetail> implements MovieDetailPresenter {

    private MovieDeatilView mView;
    private int movieId;
    private boolean mIsInit;
    private MovieDetailMoudel<MovieDetail> mMoudel;
    private String mLanguage;

    public MovieDeatilPresenterImpl(MovieDeatilView view,int movieId,String language) {
        super(view);
        this.mView = view;
        this.movieId = movieId;
        mMoudel = new MovieDetailMoudelImpl();
        mSubscription = mMoudel.requestMovieDeatil(this,movieId, Constant.api_key,language, null);
    }

    @Override
    public void beforeRequest() {
        if (!mIsInit) {
            mView.showProgress();
            mIsInit = true;
        }
    }

    @Override
    public void requestSuccess(MovieDetail data) {
        mView.showMovieDetail(data);
    }
}
