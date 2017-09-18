package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.Cast;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.moudel.CastMoudel;
import com.lts.movie.movie.moudel.CastMoudelImpl;
import com.lts.movie.movie.view.CastView;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class CastPresenterImpl extends BasePresenterImpl<CastView, Cast> implements CastPresenter {

    private CastView mView;
    private CastMoudel<Cast> mMoudel;

    public CastPresenterImpl(CastView view, int movieId) {
        super(view);
        this.mMoudel = new CastMoudelImpl();
        this.mView = view;
        mSubscription = mMoudel.requestionCastForMovie(this, Constant.api_key, movieId);
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);

        mView.showCast(null, msg, DataLoadType.REQUEST_DATA_FAIL);
    }

    @Override
    public void requestSuccess(Cast data) {
        mView.showCast(data == null ? null : data.getCast(), null, DataLoadType.REQUEST_DATA_SUCCESS);
    }
}
