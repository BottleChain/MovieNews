package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.Cast;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class CastMoudelImpl implements CastMoudel<Cast> {


    @Override
    public Subscription requestionCastForMovie(RequestCallback<Cast> callback, String api_key, Integer movieId) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getCastForMovie(movieId, api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<Cast>(callback));
    }
}
