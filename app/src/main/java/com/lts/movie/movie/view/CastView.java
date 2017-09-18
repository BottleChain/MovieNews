package com.lts.movie.movie.view;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.Cast;
import com.lts.movie.constant.DataLoadType;

import java.util.List;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public interface CastView extends BaseView {

    void showCast(List<Cast.CastBean> data,String msg, DataLoadType dataLoadType);
}
