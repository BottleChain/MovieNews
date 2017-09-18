package com.lts.movie.movie.moudel;

import com.lts.movie.App;
import com.lts.movie.R;
import com.lts.movie.base.BaseSubscriber;
import com.lts.movie.callback.RequestCallback;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lts on 2017/8/31.
 * Fuction:
 * Update:
 */

public class MovieMoudelImpl implements MovieMoudle<List<String>> {

    @Override
    public Subscription getMovieTabs(RequestCallback<List<String>> callback) {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {

                String[] stringArray = App.getContext().getResources().getStringArray(R.array.play_type);
                List<String> strings = Arrays.asList(stringArray);
                subscriber.onNext(strings);
                subscriber.onCompleted();

            }
        })
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callback));
    }
}
