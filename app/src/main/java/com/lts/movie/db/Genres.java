package com.lts.movie.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lts on 2017/9/7.
 * Fuction:
 * Update:
 */
@Entity
public class Genres {

    @Id
    private int id;
    private String name;

    @Generated(hash = 1375859396)
    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 319014004)
    public Genres() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
