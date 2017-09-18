package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.constant.MovieListType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public class MovieListMoudelImpl implements MovieListMoudel<NowPlayMovie>{

    @Override
    public Subscription requestMovieList(RequestCallback<NowPlayMovie> callback, MovieListType movieListType, String api_key, String language, Integer page, String region) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getNowPlayMoviesList(movieListType, api_key, language, page, region)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<NowPlayMovie>(callback));
    }
}
