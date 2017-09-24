package com.lts.movie.castdetail.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.Cast;
import com.lts.movie.bean.CastImage;
import com.lts.movie.castdetail.presenter.CastImagePresenter;
import com.lts.movie.castdetail.presenter.CastImagePresenterImpl;
import com.lts.movie.castdetail.view.CastImageView;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.widget.ThreePointLoadingView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastBioFragment extends BaseFragment<CastImagePresenter>  implements CastImageView{

    private Cast mCast;
    private RecyclerView mRecyclerView;
    private ThreePointLoadingView mLoadingView;

    public static CastBioFragment newIntences(Cast cast) {
        CastBioFragment fragment = new CastBioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.CAST,cast);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCast = getArguments().getParcelable(Constant.CAST);
        }
    }

    @Override
    public void showProgress() {
        mLoadingView.play();
    }

    @Override
    public void hideProgress() {
        mLoadingView.stop();
    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_cast_bio;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLoadingView = (ThreePointLoadingView) view.findViewById(R.id.tpl_view);
        TextView cast_bio = (TextView) view.findViewById(R.id.cast_bio);
        mPresenter = new CastImagePresenterImpl(this, mCast.getId());
        cast_bio.setText(mCast.getBiography());
    }

    @Override
    public void showCastImage(List<CastImage.ProfilesBean> data, String msg, DataLoadType dataLoadType) {
        BaseRecyclerAdapter<CastImage.ProfilesBean > adapter = new BaseRecyclerAdapter<CastImage.ProfilesBean>(mActivity,data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_cast_images;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CastImage.ProfilesBean item) {
                Picasso.with(mActivity).load(Constant.logUrl + item.getFile_path()).into(holder.getImageView(R.id.imageView));
            }
        };

        LinearLayoutManager layout = new LinearLayoutManager(mActivity);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(adapter);
    }
}
