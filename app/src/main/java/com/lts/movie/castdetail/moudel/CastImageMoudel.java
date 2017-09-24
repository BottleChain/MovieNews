package com.lts.movie.castdetail.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public interface CastImageMoudel<T> {
    Subscription requestCastImages(RequestCallback<T> callback,String api_key,int person_id);
}
