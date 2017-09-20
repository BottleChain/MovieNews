package com.lts.movie.search.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created Date:  2017/9/20.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class SearchMoudelImpl implements SearchMoudel<NowPlayMovie> {
    @Override
    public Subscription requestSearchMovieList(RequestCallback<NowPlayMovie> callback, String api_key, String language, String query) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .queryMovie(api_key, language, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<NowPlayMovie>(callback));
    }
}
