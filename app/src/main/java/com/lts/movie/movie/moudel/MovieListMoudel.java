package com.lts.movie.movie.moudel;

import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.MovieListType;

import rx.Subscription;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public interface MovieListMoudel<T> {
    Subscription requestMovieList(RequestCallback<T> callback, MovieListType movieListType,String api_key, String language, Integer page, String region);
}
