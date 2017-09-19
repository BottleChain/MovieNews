package com.lts.movie.http;

import android.util.SparseArray;

import com.lts.movie.App;
import com.lts.movie.bean.Cast;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.bean.Reviews;
import com.lts.movie.bean.Video;
import com.lts.movie.constant.HostType;
import com.lts.movie.constant.MovieListType;
import com.lts.movie.util.NetUtil;
import com.socks.library.KLog;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


/**
 * Created by lts on 2017/8/28.
 * Fuction: 管理retrifit 网络请求
 * Update:
 */

public class RetrofitManager {

    // 设缓存有效期为两天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    // 30秒内直接读缓存
    private static final long CACHE_AGE_SEC = 0;
    private Api mApi;

    //私有构造,不许再别的地方创建对象;
    private RetrofitManager(){}

    private static volatile OkHttpClient sOkHttpClient;

    // 管理不同HostType的单例
    private static SparseArray<RetrofitManager> sInstanceManager = new SparseArray<>(HostType.values().length);

    // 云端响应头拦截器，用来配置缓存策略
    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            // 在这里统一配置请求头缓存策略以及响应头缓存策略
            if (NetUtil.isConnected(App.getContext())) {
                // 在有网的情况下CACHE_AGE_SEC秒内读缓存，大于CACHE_AGE_SEC秒后会重新请求数据
                request = request.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control", "public, max-age=" + CACHE_AGE_SEC).build();
                Response response = chain.proceed(request);
                return response.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control", "public, max-age=" + CACHE_AGE_SEC).build();
            } else {
                // 无网情况下CACHE_STALE_SEC秒内读取缓存，大于CACHE_STALE_SEC秒缓存无效报504
                request = request.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC).build();
                Response response = chain.proceed(request);
                return response.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC).build();
            }

        }
    };


    // 打印返回的json数据拦截器
    private Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            Request.Builder requestBuilder = request.newBuilder();
            requestBuilder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
            request = requestBuilder.build();

            final Response response = chain.proceed(request);

            KLog.e("请求网址: \n" + request.url() + " \n " + "请求头部信息：\n" + request.headers() + "响应头部信息：\n" + response.headers());

            final ResponseBody responseBody = response.body();
            final long contentLength = responseBody.contentLength();

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(charset);
                } catch (UnsupportedCharsetException e) {
                    KLog.e("");
                    KLog.e("Couldn't decode the response body; charset is likely malformed.");
                    return response;
                }
            }

            if (contentLength != 0) {
                KLog.v("--------------------------------------------开始打印返回数据----------------------------------------------------");
                KLog.json(buffer.clone().readString(charset));
                KLog.v("--------------------------------------------结束打印返回数据----------------------------------------------------");
            }

            return response;
        }
    };

    private RetrofitManager(HostType hostType) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HostType.getHosType(hostType))
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApi = retrofit.create(Api.class);
    }

    private OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (sOkHttpClient == null) {
                    // OkHttpClient配置是一样的,静态创建一次即可
                    // 指定缓存路径,缓存大小100Mb
                    Cache cache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);

                    sOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mLoggingInterceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .build();

                }
            }
        }
        return sOkHttpClient;
    }


    /**
     * 获取单例
     *
     * @param hostType host类型
     * @return 实例
     */
    public static RetrofitManager getInstance(HostType hostType) {
        RetrofitManager instance = sInstanceManager.get(HostType.getIndex(hostType));
        if (instance == null) {
            instance = new RetrofitManager(hostType);
            sInstanceManager.put(HostType.getIndex(hostType), instance);
            return instance;
        } else {
            return instance;
        }
    }

    public Observable<NowPlayMovie> getNowPlayMoviesList(MovieListType movieListType,String api_key, String language, Integer page, String region) {
        switch (movieListType) {
            case NOW_PLAYING:
                return mApi.getNowPlayMovies(api_key, language, page, region);
            case POPULAR:
                return mApi.getPopularMovies(api_key, language, page, region);
            case TOPRATED:
                return mApi.getTopRatedMoives(api_key, language, page, region);
            case UPCOMING:
                return mApi.getUpcoming(api_key, language, page, region);
        }

        return null;
    }

    public Observable<MovieDetail> getMovieDetail(int movieId,String api_key, String language, String apped_to_response) {
        return mApi.getMovieDetail(movieId, api_key, language, apped_to_response);
    }

   public Observable<Cast> getCastForMovie(Integer movieId,String api_key) {
       return mApi.getCastForMovie(movieId, api_key);
   }

    public Observable<Reviews> getReviews(Integer movieId, String api_key, String lauguage, Integer page) {
        return mApi.getReviews(movieId, api_key, lauguage, page);
    }

    public Observable<Video> getMovieVideo(int movie_id, String api_key, String language) {
        return mApi.getMovieVideoList(movie_id, api_key, language);
    }

}
