package com.lts.movie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class Cast implements Parcelable{


    /**
     * birthday : 1965-11-02
     * deathday : null
     * id : 35742
     * name : Shah Rukh Khan
     * also_known_as : ["SRK","Shahrukh Khan","शाहरुख़ ख़ान","شاہ رخ خان","King Khan","Shah Rukh"]
     * gender : 2
     * biography : From Wikipedia, the free encyclopedia.

     Shahrukh Khan ( born 2 November 1965), often credited as Shah Rukh Khan, is an Indian film actor and a prominent Bollywood figure, as well as a film producer and television host. Khan began his career appearing in several television serials in the late 1980s. He made his film debut in Deewana (1992). Since then, he has been part of numerous commercially successful films and has earned critical acclaim for many of his performances. Khan has won fourteen Filmfare Awards for his work in Indian films, eight of which are in the Best Actor category (a record). In 2005, the Government of India honoured him with the Padma Shri for his contributions towards Indian Cinema.

     Khan's films such as Dilwale Dulhaniya Le Jayenge (1995), Kuch Kuch Hota Hai (1998), Chak De India (2007), Om Shanti Om (2007) and Rab Ne Bana Di Jodi (2008) remain some of Bollywood's biggest hits, while films like Kabhi Khushi Kabhie Gham (2001), Kal Ho Naa Ho (2003), Veer-Zaara (2004), Kabhi Alvida Naa Kehna (2006) and My Name Is Khan (2010) have been top-grossing Indian productions in the overseas markets, making him one of the most successful actors of India. Since 2000, Khan branched out into film production and television presenting as well. He is the founder/owner of two production companies, Dreamz Unlimited and Red Chillies Entertainment. Known globally to his fans as SRK, Khan is considered to be one of the biggest movie stars, with a fan following numbering in the billions[4] and a net worth estimated at over Indian Rupee ₹2,500 crore (US$555 million). In 2008, Newsweek named him one of the 50 most powerful people in the world.

     Description above from the Wikipedia article Shahrukh Khan, licensed under CC-BY-SA, full list of contributors on Wikipedia.
     * popularity : 2.205797
     * place_of_birth : New Delhi, India
     * profile_path : /unfoh4zAiPvnQsHeE2CUgpNOX9u.jpg
     * adult : false
     * imdb_id : nm0451321
     * homepage : null
     */

    private String birthday;

    private int id;
    private String name;
    private int gender;
    private String biography;
    private double popularity;
    private String place_of_birth;
    private String profile_path;
    private boolean adult;
    private String imdb_id;

    private List<String> also_known_as;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public List<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(List<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.birthday);

        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.gender);
        dest.writeString(this.biography);
        dest.writeDouble(this.popularity);
        dest.writeString(this.place_of_birth);
        dest.writeString(this.profile_path);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeString(this.imdb_id);

        dest.writeStringList(this.also_known_as);
    }

    public Cast() {
    }

    protected Cast(Parcel in) {
        this.birthday = in.readString();

        this.id = in.readInt();
        this.name = in.readString();
        this.gender = in.readInt();
        this.biography = in.readString();
        this.popularity = in.readDouble();
        this.place_of_birth = in.readString();
        this.profile_path = in.readString();
        this.adult = in.readByte() != 0;
        this.imdb_id = in.readString();

        this.also_known_as = in.createStringArrayList();
    }

    public static final Creator<Cast> CREATOR = new Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel source) {
            return new Cast(source);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };
}
