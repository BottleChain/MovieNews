package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.constant.MovieListType;
import com.lts.movie.movie.moudel.MovieListMoudel;
import com.lts.movie.movie.moudel.MovieListMoudelImpl;
import com.lts.movie.movie.view.MovieListView;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public class MovieListPresenterImpl extends BasePresenterImpl<MovieListView,NowPlayMovie> implements MovieListPresenter{

    private MovieListType mMovieListType;
    private int mStartPage = 1;
    private boolean mIsRefresh = true;
    private MovieListMoudel<NowPlayMovie> mMovieMovieListMoudel;
    private boolean mHasInit;
    private String mLanguage;

    public MovieListPresenterImpl(MovieListView view, MovieListType movieListType,String language) {
        super(view);
        this.mMovieListType = movieListType;
        mMovieMovieListMoudel = new MovieListMoudelImpl();
        this.mLanguage = language;
        mSubscription = mMovieMovieListMoudel.requestMovieList(this, movieListType, Constant.api_key, mLanguage, mStartPage, null);

    }

    @Override
    public void beforeRequest() {
        if (!mHasInit) {
            mHasInit = true;
            mView.showProgress();
        }
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);

        mView.updataMovieList(null,msg,mIsRefresh? DataLoadType.REQUEST_DATA_FAIL:DataLoadType.REQUST_MORE_FAIL);
    }

    @Override
    public void requestSuccess(NowPlayMovie data) {
        if (data != null) {
            mStartPage ++;
        }

        mView.updataMovieList(data == null ? null:data.getResults(),"",mIsRefresh ? DataLoadType.REQUEST_DATA_SUCCESS : DataLoadType.REQUST_MORE_DATA_SUCCESS);
    }

    @Override
    public void reFreshData() {
        mStartPage = 1;
        mIsRefresh = true;
        mSubscription = mMovieMovieListMoudel.requestMovieList(this, mMovieListType, Constant.api_key, mLanguage, mStartPage, null);
    }

    @Override
    public void loadMoreData() {
        mIsRefresh = false;
        mSubscription = mMovieMovieListMoudel.requestMovieList(this, mMovieListType, Constant.api_key,mLanguage, mStartPage, null);
    }
}
