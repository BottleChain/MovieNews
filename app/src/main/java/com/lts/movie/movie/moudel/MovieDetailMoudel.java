package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/9/5.
 * Fuction:
 * Update:
 */

public interface MovieDetailMoudel<T> {
    Subscription requestMovieDeatil(RequestCallback<T> callback, int movieId, String api_key, String language, String append_to_response);
}
