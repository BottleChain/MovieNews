package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public interface MoviePlayListMoudel<T> {
    Subscription requestMovieVideoList(RequestCallback<T> callback,String api_key,String language,int movie_id);
}
