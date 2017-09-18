package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/9/5.
 * Fuction:
 * Update:
 */

public class MovieDetailMoudelImpl implements MovieDetailMoudel<MovieDetail> {
    @Override
    public Subscription requestMovieDeatil(RequestCallback<MovieDetail> callback, int movieId, String api_key, String language, String append_to_response) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getMovieDetail(movieId, api_key, language, append_to_response)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<MovieDetail>(callback));
    }
}
