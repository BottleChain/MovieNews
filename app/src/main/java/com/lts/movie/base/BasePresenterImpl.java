package com.lts.movie.base;

import com.lts.movie.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by lts on 2017/8/28.
 * Fuction: P层的基类,
 * Update:
 */

public abstract class BasePresenterImpl<T extends BaseView,V> implements BasePresenter , RequestCallback<V> {

    protected Subscription mSubscription;
    protected T mView;

    public BasePresenterImpl(T view) {
        this.mView = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        mView = null;
    }

    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void requestError(String msg) {
        mView.hideProgress();
    }


    @Override
    public void requestComplete() {
        mView.hideProgress();
    }



}
