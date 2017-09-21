package com.lts.movie.movie.ui;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.Video;
import com.lts.movie.callback.OnItemClickAdapter;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.movie.presenter.MoviePlayListPresenter;
import com.lts.movie.movie.presenter.MoviePlaylistPresenterImpl;
import com.lts.movie.movie.view.MoviePlayView;

import java.util.List;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class MoviePlayListActivity extends BaseActivity<MoviePlayListPresenter> implements MoviePlayView{


    private int mMovieId;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefresh;
    private BaseRecyclerAdapter<Video.ResultsBean> mAdapter;


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public int bindingView() {
        return R.layout.activity_movie_list_play;
    }

    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(true);
            }
        });
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refreshData();
            }
        });

        mMovieId = getIntent().getIntExtra(Constant.movie_id, -1);
        mPresenter = new MoviePlaylistPresenterImpl(this,mMovieId);
    }

    @Override
    public void showMovieVideoList(List<Video.ResultsBean> data, String msg, DataLoadType dataLoadType) {
        if (mAdapter == null) {
            initAdapter(data);
        }

        mAdapter.showEmptyView(false, "");

        switch (dataLoadType) {
            case REQUEST_DATA_SUCCESS:
                mAdapter.setData(data);
                break;
            case REQUEST_DATA_FAIL:
                mAdapter.enableLoadMore(false);
                mAdapter.showEmptyView(true, msg);
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void initAdapter(final List<Video.ResultsBean> data) {
        mAdapter = new BaseRecyclerAdapter<Video.ResultsBean>(this,data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_movie_video_list;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, Video.ResultsBean item) {
                YouTubeThumbnailView youTubeThumbnailView = holder.getYouTubeThumbnailView(R.id.thumbnail);

                youTubeThumbnailView.initialize(Constant.YOUTUBE_KEY,new ThumbnailListener(item));

                holder.getTextView(R.id.tv_movie_video_name).setText(item.getName());
            }


        };

        mAdapter.setOnItemClickListener(new OnItemClickAdapter() {
            @Override
            public void onItemClick(View view, int position) {
                Video.ResultsBean resultsBean = mAdapter.getData().get(position);
                Intent intent = new Intent(MoviePlayListActivity.this, VideoActivity.class);
                intent.putExtra(Constant.VIDEO_NAME, resultsBean.getName());
                intent.putExtra(Constant.VIDEO_KEY, resultsBean.getKey());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MoviePlayListActivity.this, view.findViewById(R.id.thumbnail), "thumbnail");

                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private class  ThumbnailListener implements
            YouTubeThumbnailView.OnInitializedListener,
            YouTubeThumbnailLoader.OnThumbnailLoadedListener{

        private Video.ResultsBean mResultsBean;

        public ThumbnailListener(Video.ResultsBean bean){
            this.mResultsBean = bean;
        }


        @Override
        public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {

        }

        @Override
        public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
            youTubeThumbnailView.setImageResource(R.drawable.no_thumbnail);
        }

        @Override
        public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
            youTubeThumbnailLoader.setVideo(mResultsBean.getKey());
        }

        @Override
        public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
            youTubeThumbnailView.setImageResource(R.drawable.no_thumbnail);
        }
    }
}
