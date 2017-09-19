package com.lts.movie.constant;


import com.lts.movie.App;
import com.lts.movie.R;

import java.util.List;

/**
 * Created by lts on 2017/9/15.
 * Fuction:
 * Update:
 */

public enum Genres {

    ACTION(28, App.getContext().getResources().getString(R.string.action)),

    ADVENTURE(12,App.getContext().getResources().getString(R.string.adventrue)),

    ANIMATION(16,App.getContext().getResources().getString(R.string.animation)),

    COMEDY(35,App.getContext().getResources().getString(R.string.comedy)),

    CIRME(80,App.getContext().getResources().getString(R.string.crime)),

    DOCUMENTARY(99,App.getContext().getResources().getString(R.string.documentary)),

    DRAMA(18,App.getContext().getResources().getString(R.string.drama)),

    FAMILY(10751,App.getContext().getResources().getString(R.string.family)),

    FANTASY(14,App.getContext().getResources().getString(R.string.fantasy)),

    HISTORY(36,App.getContext().getResources().getString(R.string.history)),

    HORROR(27,App.getContext().getResources().getString(R.string.horror)),

    MUSIC(10402,App.getContext().getResources().getString(R.string.music)),

    MYSTERY(9648,App.getContext().getResources().getString(R.string.mystery)),

    ROMANCE(10749,App.getContext().getResources().getString(R.string.romance)),

    SCIENCE_FICTION(878,"Science Fiction"),

    TV_MOVIE(10770,"TV Movie"),

    THRILLER(53,App.getContext().getResources().getString(R.string.thriller)),

    WAR(10752,App.getContext().getResources().getString(R.string.war)),

    WESTERN(37,App.getContext().getResources().getString(R.string.western));


    private int id;
    private String name;

    Genres(int id,String name){
        this.id = id;
        this.name = name;
    }

    public static String getName(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size(); i++) {

            for (Genres genres : Genres.values()) {
                if (arr.get(i) == genres.id) {
                    sb.append(genres.name);
                    if (i != arr.size() - 1) {
                        sb.append(", ");
                    }
                }
            }
        }

        return sb.toString();
    }
}
