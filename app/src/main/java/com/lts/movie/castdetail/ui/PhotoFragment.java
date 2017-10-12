package com.lts.movie.castdetail.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

import com.lts.movie.R;
import com.lts.movie.base.BaseFragment;
import com.lts.movie.constant.Constant;
import com.lts.movie.util.PicassoUtil;
import com.squareup.picasso.Callback;

import uk.co.senab.photoview.PhotoView;

/**
 * Created Date:  2017/9/29.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class PhotoFragment extends BaseFragment {

    private String mImagePath;

    public static PhotoFragment newIntences(String path) {
        PhotoFragment photoFragment = new PhotoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.PHOTO_PAHT, path);
        photoFragment.setArguments(bundle);

        return photoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mImagePath = getArguments().getString(Constant.PHOTO_PAHT);
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
        return R.layout.fragment_photo;
    }

    @Override
    public void initView(View view) {
        final PhotoView photoView = (PhotoView) view.findViewById(R.id.photoView);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);

//                Picasso.with(mActivity).load(mImagePath).into(photoView);
//        Picasso picasso = new Picasso.Builder(getContext()).downloader(new OkHttp3Downloader(mActivity)).build();

        PicassoUtil.Intences(getContext()).load(mImagePath).into(photoView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

    }
}
