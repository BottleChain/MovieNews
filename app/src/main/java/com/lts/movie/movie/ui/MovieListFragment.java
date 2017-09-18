package com.lts.movie.movie.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.OnEmptyClickListener;
import com.lts.movie.callback.OnItemClickAdapter;
import com.lts.movie.callback.OnLoadMoreListener;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.constant.Genres;
import com.lts.movie.constant.MovieListType;
import com.lts.movie.movie.presenter.MovieListPresenter;
import com.lts.movie.movie.presenter.MovieListPresenterImpl;
import com.lts.movie.movie.view.MovieListView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lts on 2017/9/2.
 * Fuction:
 * Update:
 */

public class MovieListFragment extends BaseFragment<MovieListPresenter> implements MovieListView{

    private MovieListType mMovie_list_type;
    private SwipeRefreshLayout mRefresh;
    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter<NowPlayMovie.ResultsBean> mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mMovie_list_type = (MovieListType) getArguments().getSerializable(Constant.movie_list_type);
        }
    }

    public static MovieListFragment newInstance(MovieListType type) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.movie_list_type,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_moive_list;
    }

    @Override
    public void initView(View view) {
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.reFreshData();
            }
        });
        mPresenter = new MovieListPresenterImpl(this,mMovie_list_type,getResources().getString(R.string.language));
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
    public void updataMovieList(List<NowPlayMovie.ResultsBean> nowPlayMovie, String msg, DataLoadType dataLoadType) {
        if (mAdapter == null) {

            initAdapter(nowPlayMovie);
        }


        mAdapter.showEmptyView(false, "");

        switch (dataLoadType) {
            case REQUEST_DATA_SUCCESS:
                mRefresh.setRefreshing(false);
                mAdapter.enableLoadMore(true);
                mAdapter.setData(nowPlayMovie);
                break;
            case REQUEST_DATA_FAIL:
                mRefresh.setRefreshing(false);
                mAdapter.enableLoadMore(false);
                mAdapter.showEmptyView(true, msg);
                mAdapter.notifyDataSetChanged();
                break;
            case REQUST_MORE_DATA_SUCCESS:
                mAdapter.loadMoreSuccess();
                if (nowPlayMovie == null || nowPlayMovie.size() == 0) {
                    mAdapter.enableLoadMore(null);
                    return;
                }

                mAdapter.addMoreData(nowPlayMovie);
                break;
            case REQUST_MORE_FAIL:
                mAdapter.loadMoreFailed(msg);
                break;
        }
    }

    private void initAdapter(List<NowPlayMovie.ResultsBean> nowPlayMovie) {

        mAdapter = new BaseRecyclerAdapter<NowPlayMovie.ResultsBean>(getActivity(),nowPlayMovie) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_movie_list;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, NowPlayMovie.ResultsBean item) {
                Picasso.with(mActivity).load(Constant.logUrl+item.getPoster_path()).into(holder.getImageView(R.id.movieLogo));
                holder.getTextView(R.id.movieTitle).setText(item.getTitle());
                holder.getTextView(R.id.movieOverView).setText(Genres.getName(item.getGenre_ids()));
                holder.getTextView(R.id.movie_release).setText(item.getRelease_date());
                holder.getTextView(R.id.movie_vote_average).setText(String.valueOf(item.getVote_average()));

            }
        };

        mAdapter.setOnItemClickListener(new OnItemClickAdapter() {
            @Override
            public void onItemClick(View view, int position) {
                NowPlayMovie.ResultsBean resultsBean = mAdapter.getData().get(position);
                Intent intent = new Intent(mActivity, MovieDetailActivity.class);
                intent.putExtra(Constant.movie_id, resultsBean.getId());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.movieLogo), "logo");

                    getActivity().startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        mAdapter.setOnEmptyClickListener(new OnEmptyClickListener() {
            @Override
            public void onEmptyClick() {
                mPresenter.reFreshData();
            }
        });

        mAdapter.setOnLoadMoreListener(20, new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                mPresenter.loadMoreData();
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.getItemAnimator().setAddDuration(250);
        mRecyclerView.getItemAnimator().setMoveDuration(250);
        mRecyclerView.getItemAnimator().setChangeDuration(250);
        mRecyclerView.getItemAnimator().setRemoveDuration(250);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAdapter = null;
        mRefresh.setRefreshing(false);

    }
}
