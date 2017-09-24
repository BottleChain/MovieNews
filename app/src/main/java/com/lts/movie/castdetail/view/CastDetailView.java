package com.lts.movie.castdetail.view;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.Cast;
import com.lts.movie.constant.DataLoadType;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public interface CastDetailView extends BaseView{

    void showCastDetail(Cast cast, String msg, DataLoadType dataLoadType);
}
