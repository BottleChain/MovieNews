package com.lts.movie.search.ui;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.constant.DataLoadType;

import java.util.List;

/**
 * Created Date:  2017/9/20.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public interface SearchView extends BaseView {

    void showMovieList(List<NowPlayMovie.ResultsBean> data, String msg, DataLoadType dataLoadType);
}
