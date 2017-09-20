package com.lts.movie.search.presenter;

import com.lts.movie.base.BasePresenterImpl;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.search.moudel.SearchMoudel;
import com.lts.movie.search.moudel.SearchMoudelImpl;
import com.lts.movie.search.ui.SearchView;

/**
 * Created Date:  2017/9/20.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class SearchPresneterImpl extends BasePresenterImpl<SearchView,NowPlayMovie> implements SearchPresenter{

    private SearchView mView;
    private SearchMoudel<NowPlayMovie> mMoudel;

    public SearchPresneterImpl(SearchView view) {
        super(view);
        this.mView = view;
        mMoudel = new SearchMoudelImpl();
    }

    @Override
    public void requestError(String msg) {
        super.requestError(msg);

        mView.showMovieList(null,msg,DataLoadType.REQUEST_DATA_FAIL);
    }

    @Override
    public void requestSuccess(NowPlayMovie data) {
        mView.showMovieList(data == null? null:data.getResults(),null, DataLoadType.REQUEST_DATA_SUCCESS);
    }

    @Override
    public void queryMovies(String query) {

        mSubscription = mMoudel.requestSearchMovieList(this, Constant.api_key, Constant.LANGUGE, query);
    }
}
