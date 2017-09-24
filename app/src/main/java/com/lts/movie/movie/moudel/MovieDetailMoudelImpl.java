package com.lts.movie.movie.moudel;

import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.HostType;
import com.lts.movie.http.RetrofitManager;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/9/5.
 * Fuction:
 * Update:
 */

public class MovieDetailMoudelImpl implements MovieDetailMoudel<MovieDetail> {
    @Override
    public Subscription requestMovieDeatil(RequestCallback<MovieDetail> callback, int movieId, String api_key, String language, String append_to_response) {
        return RetrofitManager
                .getInstance(HostType.MOVIE_HOST)
                .getMovieDetail(movieId, api_key, language, append_to_response)
                .flatMap(new Func1<MovieDetail, Observable<MovieDetail>>() {
                    @Override
                    public Observable<MovieDetail> call(final MovieDetail movieDetail) {
                        RetrofitManager
                                .getInstance(HostType.MOVIE_HOST)
                                .similarMovies(movieDetail.getId(), Constant.api_key,Constant.LANGUGE)
                                .subscribe(new Action1<NowPlayMovie>() {
                                    @Override
                                    public void call(NowPlayMovie nowPlayMovie) {
                                        movieDetail.setSimilar(nowPlayMovie);
                                    }
                                });

                        return Observable.create(new Observable.OnSubscribe<MovieDetail>(){
                            @Override
                            public void call(Subscriber<? super MovieDetail> subscriber) {
                                subscriber.onNext(movieDetail);
                                subscriber.onCompleted();
                            }
                        });
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<MovieDetail>(callback));
    }
}
