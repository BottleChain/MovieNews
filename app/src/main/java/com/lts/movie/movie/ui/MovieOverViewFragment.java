package com.lts.movie.movie.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.OnItemClickAdapter;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.Genres;
import com.lts.movie.movie.presenter.MovieDeatilPresenterImpl;
import com.lts.movie.movie.presenter.MovieDetailPresenter;
import com.lts.movie.movie.view.MovieDeatilView;
import com.lts.movie.util.PicassoUtil;
import com.lts.movie.widget.ThreePointLoadingView;

import java.util.List;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */

public class MovieOverViewFragment extends BaseFragment<MovieDetailPresenter> implements MovieDeatilView {


    TextView mTvSynopsis;

    TextView mTvYear;

    TextView mTvGenre;

    TextView mTvReleaseDate;

    TextView mTvRunTime;


    RecyclerView mRecyclerView;

    TextView mTvRevenue;

    ThreePointLoadingView mPointLoadingView;

    LinearLayout mLinearLayout;
    private int mMovieId;

    private BaseRecyclerAdapter<NowPlayMovie.ResultsBean> mAdapter;


    public static MovieOverViewFragment newIntences(int movieId) {
        MovieOverViewFragment fragment = new MovieOverViewFragment();
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
       mPointLoadingView.play();
    }

    @Override
    public void hideProgress() {
        mPointLoadingView.stop();
        mLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_moive_overview;
    }

    @Override
    public void initView(View rootView) {
        NestedScrollView scrollView = (NestedScrollView) rootView.findViewById(R.id.scrollView);
        mPointLoadingView = (ThreePointLoadingView) rootView.findViewById(R.id.tpl_view);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.root);
        mTvSynopsis = (TextView) rootView.findViewById(R.id.tv_synopsis);
        mTvYear = (TextView) rootView.findViewById(R.id.tv_year);
        mTvRunTime = (TextView) rootView.findViewById(R.id.tv_run_time);
        mTvGenre = (TextView) rootView.findViewById(R.id.tv_genre);
        mTvReleaseDate = (TextView) rootView.findViewById(R.id.tv_release_date);
        mTvRevenue = (TextView) rootView.findViewById(R.id.tv_revenue);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
        mPresenter = new MovieDeatilPresenterImpl(this, mMovieId);
    }

    @Override
    public void showMovieDetail(MovieDetail movieDetail) {
        mTvSynopsis.setText(movieDetail.getOverview());
        mTvYear.setText(movieDetail.getBudgets());
        mTvRunTime.setText(movieDetail.getRuntimes());
        mTvGenre.setText(movieDetail.getGenresFormat());
        mTvReleaseDate.setText(movieDetail.getRelease_date());
        mTvRevenue.setText(movieDetail.getRevenues());
        showSimilar(movieDetail.getSimilar().getResults());

    }

    private void showSimilar(List<NowPlayMovie.ResultsBean> results) {

        initAdapter(results);
    }

    private void initAdapter( List<NowPlayMovie.ResultsBean> results) {
        mAdapter = new BaseRecyclerAdapter<NowPlayMovie.ResultsBean>(mActivity,results) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_similar_layout;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, NowPlayMovie.ResultsBean item) {
                PicassoUtil.Intences(mActivity).load(Constant.logUrl + item.getPoster_path()).into(holder.getImageView(R.id.movie_logo));
                holder.getTextView(R.id.movie_name).setText(item.getTitle());
                holder.getTextView(R.id.movie_type).setText(Genres.getName(item.getGenre_ids()));
            }
        };

        mAdapter.setOnItemClickListener(new OnItemClickAdapter() {
            @Override
            public void onItemClick(View view, int position) {
                NowPlayMovie.ResultsBean resultsBean = mAdapter.getData().get(position);
                Intent intent = new Intent(mActivity, MovieDetailActivity.class);
                intent.putExtra(Constant.movie_id, resultsBean.getId());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.movie_logo), "logo");

                    mActivity.startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
