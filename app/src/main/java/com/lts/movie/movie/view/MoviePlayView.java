package com.lts.movie.movie.view;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.Video;
import com.lts.movie.constant.DataLoadType;

import java.util.List;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public interface MoviePlayView extends BaseView {

    void showMovieVideoList(List<Video.ResultsBean> data, String msg, DataLoadType dataLoadType);
}
