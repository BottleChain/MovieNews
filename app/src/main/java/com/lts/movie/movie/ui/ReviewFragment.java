package com.lts.movie.movie.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.Reviews;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.presenter.ReviewPresenter;
import com.lts.movie.movie.presenter.ReviewPresenterImpl;
import com.lts.movie.movie.view.ReviewView;

import java.util.List;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */

public class ReviewFragment extends BaseFragment<ReviewPresenter> implements ReviewView {

    private int mMovieId;
    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter<Reviews.ResultsBean> mAdapter;

    public static ReviewFragment newIntences(int movieId) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.movie_id, movieId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovieId = getArguments().getInt(Constant.movie_id);
        }
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_review;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mPresenter = new ReviewPresenterImpl(this, mMovieId,getResources().getString(R.string.language));
    }

    @Override
    public void showReviews(List<Reviews.ResultsBean> data, String msg, DataLoadType dataLoadType) {
        initAdapter(data);
    }

    private void initAdapter(final List<Reviews.ResultsBean> data) {
        mAdapter = new BaseRecyclerAdapter<Reviews.ResultsBean>(mActivity,data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_review;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, Reviews.ResultsBean item) {
                holder.getTextView(R.id.review_name).setText(item.getAuthor());
                holder.getTextView(R.id.review_content).setText(item.getContent());
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }
}
