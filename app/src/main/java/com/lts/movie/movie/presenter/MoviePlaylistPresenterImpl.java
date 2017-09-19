package com.lts.movie.movie.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.Video;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.moudel.MoviePlayListMoudel;
import com.lts.movie.movie.moudel.MoviePlayListMoudelImpl;
import com.lts.movie.movie.view.MoviePlayView;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class MoviePlaylistPresenterImpl extends BasePresenterImpl<MoviePlayView,Video> implements MoviePlayListPresenter{

    private int movie_id;
    private MoviePlayListMoudel<Video> mMoudel;
    private MoviePlayView mView;


    public MoviePlaylistPresenterImpl(MoviePlayView view,int movie_id) {
        super(view);
        this.mView = view;
        this.movie_id = movie_id;
        mMoudel = new MoviePlayListMoudelImpl();
        mSubscription = mMoudel.requestMovieVideoList(this, Constant.api_key, "en-US", movie_id);
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);
        mView.showMovieVideoList(null,msg,DataLoadType.REQUEST_DATA_FAIL);
    }

    @Override
    public void requestSuccess(Video data) {
        mView.showMovieVideoList(data == null? null:data.getResults(),null, DataLoadType.REQUEST_DATA_SUCCESS);
    }

    @Override
    public void refreshData() {
        mSubscription = mMoudel.requestMovieVideoList(this, Constant.api_key, "en-US", movie_id);
    }


}
