package com.lts.movie.bean;

import com.lts.movie.db.Genres;

import java.util.List;

/**
 * Created by lts on 2017/9/15.
 * Fuction:
 * Update:
 */

public class MovieType {
    private List<Genres> genres;

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
}
