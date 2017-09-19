package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.Video;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class MoviePlayListMoudelImpl implements MoviePlayListMoudel<Video> {
    @Override
    public Subscription requestMovieVideoList(RequestCallback<Video> callback, String api_key, String language, int movie_id) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getMovieVideo(movie_id, api_key, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<Video>(callback));
    }
}
