package com.lts.movie.movie.ui;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.lts.movie.R;
import com.lts.movie.base.YouTubeFailureRecoveryActivity;
import com.lts.movie.constant.Constant;

/**
 * Created Date:  2017/9/19.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class VideoActivity extends YouTubeFailureRecoveryActivity{


    private String mVideoName;
    private String mVideo_key;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        youTubeView.initialize(Constant.YOUTUBE_KEY, this);

        mVideoName = getIntent().getStringExtra(Constant.VIDEO_NAME);
        mVideo_key = getIntent().getStringExtra(Constant.VIDEO_KEY);
    }


    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.cueVideo(mVideo_key);
        }
    }
}
