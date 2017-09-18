package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/8/31.
 * Fuction:
 * Update:
 */

public interface MovieMoudle<T> {
    Subscription getMovieTabs(RequestCallback<T> callback);
}
