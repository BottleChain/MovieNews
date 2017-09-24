package com.lts.movie.castdetail.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.Cast;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastDetailMoudelImpl implements CastDeatilMoudel<Cast> {
    @Override
    public Subscription requestCastDetail(RequestCallback<Cast> callback, int person_id, String api_key, String language) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getCastDetail(person_id, api_key, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callback));
    }
}
