package com.lts.movie.search.ui;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.base.BaseRecyclerAdapter;
import com.lts.movie.base.BaseRecyclerViewHolder;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.callback.OnItemClickAdapter;
import com.lts.movie.constant.Constant;
import com.lts.movie.constant.DataLoadType;
import com.lts.movie.constant.Genres;
import com.lts.movie.movie.ui.MovieDetailActivity;
import com.lts.movie.search.presenter.SearchPresenter;
import com.lts.movie.search.presenter.SearchPresneterImpl;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lts on 2017/9/19.
 * Fuction:
 * Update:
 */

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView{


    private EditText mEditText;
    private SwipeRefreshLayout mRefresh;
    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter<NowPlayMovie.ResultsBean> mAdapter;

    @Override
    public void showProgress() {
        mRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public int bindingView() {
        return R.layout.activity_search;
    }

    @Override
    public boolean isHasNavigationView() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_clear) {
            mEditText.setText("");
            if (mAdapter.getData() != null) {
                mAdapter.getData().clear();
                mAdapter.notifyDataSetChanged();

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_clear, menu);

        return true;
    }

    @Override
    public void initView() {
        mEditText = (EditText) findViewById(R.id.search_view);
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mPresenter = new SearchPresneterImpl(this);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefresh.setRefreshing(false);
            }
        });
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s)) {
                    mPresenter.queryMovies(s.toString());
                }
            }
        });

    }

    @Override
    public void showMovieList(List<NowPlayMovie.ResultsBean> data, String msg, DataLoadType dataLoadType) {
        if (mAdapter == null) {
            initAdapter(data);
        }

        mAdapter.showEmptyView(false, "");

        switch (dataLoadType) {
            case REQUEST_DATA_SUCCESS:
                mAdapter.setData(data);
                break;
            case REQUEST_DATA_FAIL:
                mAdapter.showEmptyView(true, msg);
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void initAdapter(final List<NowPlayMovie.ResultsBean> data) {
        mAdapter = new BaseRecyclerAdapter<NowPlayMovie.ResultsBean>(this,data) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_movie_list;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, NowPlayMovie.ResultsBean item) {
                Picasso.with(SearchActivity.this).load(Constant.logUrl+item.getPoster_path()).into(holder.getImageView(R.id.movieLogo));
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
                Intent intent = new Intent(SearchActivity.this, MovieDetailActivity.class);
                intent.putExtra(Constant.movie_id, resultsBean.getId());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SearchActivity.this, view.findViewById(R.id.movieLogo), "logo");

                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
