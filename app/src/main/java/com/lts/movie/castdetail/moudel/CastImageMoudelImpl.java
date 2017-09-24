package com.lts.movie.castdetail.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.CastImage;
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

public class CastImageMoudelImpl implements CastImageMoudel<CastImage> {
    @Override
    public Subscription requestCastImages(RequestCallback<CastImage> callback, String api_key, int person_id) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getCastImage(person_id, api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<CastImage>(callback));
    }
}
