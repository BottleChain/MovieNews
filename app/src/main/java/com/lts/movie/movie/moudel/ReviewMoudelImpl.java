package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.Reviews;
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

public class ReviewMoudelImpl implements ReviewMoudel<Reviews> {

    @Override
    public Subscription requestReview(RequestCallback<Reviews> callback, Integer movieId, String api_key, String language, Integer page) {

        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getReviews(movieId, api_key, language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<Reviews>(callback));
    }
}
