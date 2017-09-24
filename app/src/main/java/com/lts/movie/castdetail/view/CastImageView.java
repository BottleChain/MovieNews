package com.lts.movie.castdetail.view;

import com.lts.movie.base.BaseView;
import com.lts.movie.bean.CastImage;
import com.lts.movie.constant.DataLoadType;

import java.util.List;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public interface CastImageView extends BaseView{

    void showCastImage(List<CastImage.ProfilesBean> data, String msg, DataLoadType dataLoadType);
}
