package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public interface ReviewMoudel<T> {

    Subscription requestReview(RequestCallback<T> callback, Integer movieId, String api_key, String language, Integer page);
}
