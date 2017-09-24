package com.lts.movie.castdetail.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public interface CastDeatilMoudel<T> {

    Subscription requestCastDetail(RequestCallback<T> callback,int person_id,String api_key,String language);
}
