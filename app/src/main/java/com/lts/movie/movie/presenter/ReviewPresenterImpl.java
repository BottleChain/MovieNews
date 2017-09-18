package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.Reviews;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.moudel.ReviewMoudel;
import com.lts.movie.movie.moudel.ReviewMoudelImpl;
import com.lts.movie.movie.view.ReviewView;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class ReviewPresenterImpl extends BasePresenterImpl<ReviewView,Reviews> implements ReviewPresenter{

    private ReviewView mView;
    private ReviewMoudel<Reviews> mMoudel;
    private int mStartPage;
    private int mMovieId;


    public ReviewPresenterImpl(ReviewView view,int movieId,String language) {
        super(view);
        this.mView = view;
        this.mMovieId = movieId;
        this.mMoudel = new ReviewMoudelImpl();
        mStartPage = 1;
        mSubscription = mMoudel.requestReview(this, movieId, Constant.api_key, language, mStartPage);
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);
    }

    @Override
    public void requestSuccess(Reviews data) {
        if (data != null) {
            mStartPage ++;
        }

        mView.showReviews(data == null? null:data.getResults(),null, DataLoadType.REQUEST_DATA_SUCCESS);
    }
}
