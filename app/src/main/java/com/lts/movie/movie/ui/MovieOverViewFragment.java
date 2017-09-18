package com.lts.movie.movie.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.constant.Constant;
import com.lts.movie.movie.presenter.MovieDeatilPresenterImpl;
import com.lts.movie.movie.presenter.MovieDetailPresenter;
import com.lts.movie.movie.view.MovieDeatilView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */

public class MovieOverViewFragment extends BaseFragment<MovieDetailPresenter> implements MovieDeatilView {

    @InjectView(R.id.tv_synopsis)
    TextView mTvSynopsis;
    @InjectView(R.id.tv_year)
    TextView mTvYear;
    @InjectView(R.id.tv_genre)
    TextView mTvGenre;
    @InjectView(R.id.tv_release_date)
    TextView mTvReleaseDate;
    @InjectView(R.id.tv_run_time)
    TextView mTvRunTime;
    @InjectView(R.id.tv_certification)
    TextView mTvCertification;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @InjectView(R.id.tv_revenue)
    TextView mTvRevenue;
    private int mMovieId;

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

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingLayou() {
        return R.layout.fragment_moive_overview;
    }

    @Override
    public void initView(View rootView) {
        ButterKnife.inject(this, rootView);
        mPresenter = new MovieDeatilPresenterImpl(this, mMovieId,getResources().getString(R.string.language));
    }

    @Override
    public void showMovieDetail(MovieDetail movieDetail) {
        mTvSynopsis.setText(movieDetail.getOverview());
        mTvYear.setText(movieDetail.getBudgets());
        mTvRunTime.setText(movieDetail.getRuntimes());
        mTvGenre.setText(movieDetail.getGenresFormat());
        mTvReleaseDate.setText(movieDetail.getRelease_date());
        mTvRevenue.setText(movieDetail.getRevenues());

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
