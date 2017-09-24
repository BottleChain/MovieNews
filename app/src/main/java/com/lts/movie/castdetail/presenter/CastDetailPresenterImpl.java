package com.lts.movie.castdetail.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.Cast;
import com.lts.movie.castdetail.moudel.CastDeatilMoudel;
import com.lts.movie.castdetail.moudel.CastDetailMoudelImpl;
import com.lts.movie.castdetail.view.CastDetailView;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastDetailPresenterImpl extends BasePresenterImpl<CastDetailView,Cast> implements CastDetailPresenter{

    private CastDetailView mView;
    private int person_id;
    private CastDeatilMoudel<Cast> mMoudel;


    public CastDetailPresenterImpl(CastDetailView view,int person_id) {
        super(view);
        this.mView = view;
        this.person_id = person_id;
        mMoudel = new CastDetailMoudelImpl();
        mSubscription = mMoudel.requestCastDetail(this, person_id, Constant.api_key, Constant.LANGUGE);
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);

    }

    @Override
    public void requestSuccess(Cast data) {
        mView.showCastDetail(data,null, DataLoadType.REQUEST_DATA_SUCCESS);
    }


}
