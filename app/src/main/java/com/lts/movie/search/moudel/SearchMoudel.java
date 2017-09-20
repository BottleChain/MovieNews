package com.lts.movie.search.moudel;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created Date:  2017/9/20.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public interface SearchMoudel<T> {

    Subscription requestSearchMovieList(RequestCallback<T> callback,String api_key,String language,String query);
}
