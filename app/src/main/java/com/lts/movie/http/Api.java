package com.lts.movie.http;

import com.lts.movie.bean.Cast;
import com.lts.movie.bean.CastImage;
import com.lts.movie.bean.CastList;
import com.lts.movie.bean.MovieDetail;
import com.lts.movie.bean.NowPlayMovie;
import com.lts.movie.bean.Reviews;
import com.lts.movie.bean.Video;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by lts on 2017/8/28.
 * Fuction: 后台接口 doc<a href="https://developers.themoviedb.org/3">自己去看,老子懒得写注释</a>
 * Update:
 */

public interface Api {

    @GET("movie/now_playing")
    Observable<NowPlayMovie> getNowPlayMovies(@Query("api_key") String api_key,
                                              @Query("language") String language,
                                              @Query("page") Integer page,
                                              @Query("region") String region);

    @GET("movie/popular")
    Observable<NowPlayMovie> getPopularMovies(@Query("api_key") String api_key,
                                              @Query("language") String language,
                                              @Query("page") Integer page,
                                              @Query("region") String region);

    @GET("movie/top_rated")
    Observable<NowPlayMovie> getTopRatedMoives(@Query("api_key") String api_key,
                                               @Query("language") String language,
                                               @Query("page") Integer page,
                                               @Query("region") String region);

    @GET("movie/upcoming")
    Observable<NowPlayMovie> getUpcoming(@Query("api_key") String api_key,
                                         @Query("language") String language,
                                         @Query("page") Integer page,
                                         @Query("region") String region);

    @GET("movie/{movie_id}")
    Observable<MovieDetail> getMovieDetail(@Path("movie_id") int movie_id,
                                           @Query("api_key") String api_key,
                                           @Query("language") String language,
                                           @Query("append_to_response") String append_to_response);

    @GET("movie/{movie_id}/credits")
    Observable<CastList> getCastForMovie(@Path("movie_id") Integer movie_id,
                                         @Query("api_key") String api_key);
    @GET("movie/{movie_id}/reviews")
    Observable<Reviews> getReviews(@Path("movie_id") Integer movieId,
                                   @Query("api_key") String api_key,
                                   @Query("language") String language,
                                   @Query("page") Integer page);

    @GET("movie/{movie_id}/videos")
    Observable<Video> getMovieVideoList(@Path("movie_id") int id,
                                        @Query("api_key") String api_key,
                                        @Query("language") String language);
    @GET("search/movie")
    Observable<NowPlayMovie> queryMovie(@Query("api_key") String api_key,
                                        @Query("language") String language,
                                        @Query("query") String query);

    @GET("movie/{movie_id}/similar")
    Observable<NowPlayMovie> similarMovie(@Path("movie_id") Integer movie_id,
                                          @Query("api_key") String api_key,
                                          @Query("language") String language);
    @GET("person/{person_id}")
    Observable<Cast> requestCastDetail(@Path("person_id") int persion_id,
                                       @Query("api_key") String api_key,
                                       @Query("language") String language);
    @GET("person/{person_id}/images")
    Observable<CastImage> requestCastImage(@Path("person_id") int person_id,
                                           @Query("api_key") String api_key);
}
