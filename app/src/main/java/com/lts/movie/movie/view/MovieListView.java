package com.lts.movie.movie.view;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.constant.DataLoadType;

import java.util.List;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public interface MovieListView extends BaseView {

    void updataMovieList(List<NowPlayMovie.ResultsBean> nowPlayMovie, String msg, DataLoadType dataLoadType);
}
