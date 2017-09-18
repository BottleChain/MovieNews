package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public interface CastMoudel<T> {
    Subscription requestionCastForMovie(RequestCallback<T> callback,String api_key,Integer movieId);
}
