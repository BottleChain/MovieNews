package com.lts.movie;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.util.DisplayMetrics;

import com.lts.movie.constant.Constant;
import com.lts.movie.db.DaoMaster;
import com.lts.movie.db.DaoSession;
import com.lts.movie.util.SpUtils;
import com.socks.library.KLog;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.Locale;

/**
 * Created by lts on 2017/8/28.
 *
 */

public class App extends Application {

    private static Context mContext;
    private DaoSession mDaoSession;

    {
        PlatformConfig.setSinaWeibo("2444532708", "88700b6a5e404ba5a112d2d10426adab", "https://developers.themoviedb.org/3");
        PlatformConfig.setWeixin("wxb9e86f1ca7125331", "dc14a0ff65e4601ce10338f3bb195cee");
        PlatformConfig.setQQZone("1106380059","zyufAV2LHaMgVSAM");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        KLog.init(BuildConfig.DEBUG);
        mContext = this;
        initGreenDao();
        UMShareAPI.get(this);
    }

    private void initGreenDao() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constant.movie_news_db);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();

        DisplayMetrics dm = getResources().getDisplayMetrics();
        Configuration config = getResources().getConfiguration();
        config.locale = getSetLocale();
        getResources().updateConfiguration(config,dm);
    }

    private Locale getSetLocale() {
        int i = SpUtils.readInt(Constant.LOCALE);

        switch (i) {
            case 0:
                return Locale.getDefault();
            case 1:
                return Locale.SIMPLIFIED_CHINESE;
            case 2:
                return Locale.US;
        }
        return Locale.getDefault();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static Context getContext() {
        return mContext;
    }
}
