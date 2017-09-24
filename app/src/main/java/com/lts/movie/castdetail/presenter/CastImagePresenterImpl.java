package com.lts.movie.castdetail.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.CastImage;
import com.lts.movie.castdetail.moudel.CastImageMoudel;
import com.lts.movie.castdetail.moudel.CastImageMoudelImpl;
import com.lts.movie.castdetail.view.CastImageView;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastImagePresenterImpl extends BasePresenterImpl<CastImageView,CastImage> implements CastImagePresenter{

    private CastImageView mView;
    private int personId;
    private CastImageMoudel<CastImage> mMoudel;



    public CastImagePresenterImpl(CastImageView view,int personId) {
        super(view);
        this.mView = view;
        this.personId = personId;
        mMoudel = new CastImageMoudelImpl();
        mSubscription = mMoudel.requestCastImages(this, Constant.api_key, personId);
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);
    }

    @Override
    public void requestSuccess(CastImage data) {
        mView.showCastImage(data == null ? null : data.getProfiles(),null, DataLoadType.REQUEST_DATA_SUCCESS);
    }
}
