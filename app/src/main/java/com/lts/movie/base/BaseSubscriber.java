package com.lts.movie.base;


import com.lts.movie.App;
import com.lts.movie.callback.RequestCallback;
import com.lts.movie.util.NetUtil;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by lts on 2017/8/28.
 * Fuction:网络请求回调基类,在这对返回错误做统一处理
 * Update:
 */

public class BaseSubscriber<T> extends Subscriber<T> {

    private RequestCallback<T> mRequestCallback;

    public BaseSubscriber(RequestCallback<T> requestCallback) {
        this.mRequestCallback = requestCallback;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mRequestCallback != null) {
            mRequestCallback.beforeRequest();
        }
    }

    @Override
    public void onCompleted() {
        if (mRequestCallback != null) {
            mRequestCallback.requestComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mRequestCallback != null) {
            String errorMsg = null;

            if (e instanceof HttpException) {
                switch (((HttpException) e).code()) {
                    case 401:
                        errorMsg = "Authentication failed: You do not have permissions to access the service.";
                        break;
                    case 403:
                        errorMsg = "Duplicate entry: The data you tried to submit already exists.";
                        break;
                    case 404:
                        errorMsg = "Invalid id: The pre-requisite id is invalid or not found.";
                        break;
                    case 503:
                        errorMsg = "Service offline: This service is temporarily offline, try again later.";
                        break;
                    case 504:
                        if (NetUtil.isConnected(App.getContext())) {
                            errorMsg = "没有联网! ";
                        } else {
                            errorMsg = "网络连接超时";
                        }
                        break;
                    default:
                        errorMsg = ((HttpException) e).message();
                        break;
                }
            } else if (e instanceof UnknownHostException) {
                errorMsg = "不知名主机";
            } else if (e instanceof SocketTimeoutException) {
                errorMsg = "网络连接超时";
            } else {
                errorMsg = "未知错误！！！";
            }

            mRequestCallback.requestError(errorMsg);
        }
    }

    @Override
    public void onNext(T t) {
        if (mRequestCallback != null) {
            mRequestCallback.requestSuccess(t);
        }
    }
}
