package com.lts.movie.movie.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.CastList;
import com.lts.movie.callback.OnItemClickAdapter;
import com.lts.movie.castdetail.ui.CastDetailActivity;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.presenter.CastPresenter;
import com.lts.movie.movie.presenter.CastPresenterImpl;
import com.lts.movie.movie.view.CastView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */

public class CastFragment extends BaseFragment<CastPresenter> implements CastView {

    private int mMovieId;
    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter<CastList.CastBean> mAdapter;
    private SwipeRefreshLayout mRefresh;

    public static CastFragment newIntences(int movieId) {
        CastFragment fragment = new CastFragment();
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
        mRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_people;
    }

    @Override
    public void initView(View view) {
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(true);
            }
        });

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.reFreshData();
            }
        });
        mPresenter = new CastPresenterImpl(this, mMovieId);
    }

    @Override
    public void showCast(List<CastList.CastBean> data, String msg, DataLoadType dataLoadType) {

        initAdapter(data);
    }

    private void initAdapter(final List<CastList.CastBean> data) {
        mAdapter = new BaseRecyclerAdapter<CastList.CastBean>(mActivity,data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_cast;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CastList.CastBean item) {
                ImageView imageView = holder.getImageView(R.id.cast_photo);
                Picasso.with(mActivity).load(Constant.logUrl + item.getProfile_path()).into(imageView);
                holder.getTextView(R.id.cast_character).setText(item.getCharacter());
                holder.getTextView(R.id.cast_name).setText(item.getName());
            }
        };

        mAdapter.setOnItemClickListener(new OnItemClickAdapter() {
            @Override
            public void onItemClick(View view, int position) {
                CastList.CastBean castBean = mAdapter.getData().get(position);
                Intent intent = new Intent(mActivity, CastDetailActivity.class);
                intent.putExtra(Constant.CAST_ID, castBean.getId());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, view.findViewById(R.id.cast_photo), "cast");

                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
        mRecyclerView.setAdapter(mAdapter);
    }
}
