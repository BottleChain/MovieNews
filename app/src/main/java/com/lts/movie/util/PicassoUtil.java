package com.lts.movie.util;

import android.annotation.SuppressLint;
import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created Date:  2017/10/11.
 * author: tsliu
 * email: liutangbei@gmail.com
 */

public class PicassoUtil {

    @SuppressLint("StaticFieldLeak")
    private static Picasso sPicasso;

    public static Picasso Intences(Context context) {
        if (sPicasso == null) {
            synchronized (PicassoUtil.class) {
                if (sPicasso == null) {
                    sPicasso = new Picasso.Builder(context).downloader(new OkHttp3Downloader(context)).build();
                }
            }
        }

        return sPicasso;
    }
}
