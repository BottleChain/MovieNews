package com.lts.movie.bean;

import java.util.List;

/**
 * Created by lts on 2017/9/23.
 * Fuction:
 * Update:
 */

public class CastImage {

    /**
     * profiles : [{"iso_639_1":null,"width":680,"height":1000,"vote_count":1,"vote_average":5.3125,"file_path":"/terFS9M2F8Gc46K4i057JRUK45N.jpg","aspect_ratio":0.68},{"iso_639_1":null,"width":354,"height":528,"vote_count":1,"vote_average":5.171130952381,"file_path":"/dIK6J72K7T0isnwOAXTwo4dVg75.jpg","aspect_ratio":0.67045454545455}]
     * id : 78871
     */

    private int id;
    private List<ProfilesBean> profiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProfilesBean> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfilesBean> profiles) {
        this.profiles = profiles;
    }

    public static class ProfilesBean {
        /**
         * iso_639_1 : null
         * width : 680
         * height : 1000
         * vote_count : 1
         * vote_average : 5.3125
         * file_path : /terFS9M2F8Gc46K4i057JRUK45N.jpg
         * aspect_ratio : 0.68
         */

        private Object iso_639_1;
        private int width;
        private int height;
        private int vote_count;
        private double vote_average;
        private String file_path;
        private double aspect_ratio;

        public Object getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(Object iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }
    }
}
