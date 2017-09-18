package com.lts.movie.constant;


import java.util.List;

/**
 * Created by lts on 2017/9/15.
 * Fuction:
 * Update:
 */

public enum Genres {

    ACTION(28,"Action"),

    ADVENTURE(12,"Adventure"),

    ANIMATION(16,"Animation"),

    COMEDY(35,"Comedy"),

    CIRME(80,"Crime"),

    DOCUMENTARY(99,"Documentary"),

    DRAMA(18,"Drama"),

    FAMILY(10751,"Family"),

    FANTASY(14,"Fantasy"),

    HISTORY(36,"History"),

    HORROR(27,"Horror"),

    MUSIC(10402,"Music"),

    MYSTERY(9648,"Mystery"),

    ROMANCE(10749,"Romance"),

    SCIENCE_FICTION(878,"Science Fiction"),

    TV_MOVIE(10770,"TV Movie"),

    THRILLER(53,"Thriller"),

    WAR(10752,"War"),

    WESTERN(37,"Western");


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
