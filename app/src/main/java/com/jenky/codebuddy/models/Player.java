package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JTLie on 20-5-2016.
 */
public class Player implements Parcelable{
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    private int id;
    private String name;
    private String image_head;
    private String image_shirt;
    private String image_legs;
    private int total_score;
    private int avg_score;
    private int achievements;
    private int games_played;
    private int jenkyCoins;


    public Player(){
        //Empty for initial creation
    }

    public Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image_head = in.readString();
        image_shirt = in.readString();
        image_legs = in.readString();
        total_score = in.readInt();
        avg_score = in.readInt();
        achievements = in.readInt();
        games_played = in.readInt();
        jenkyCoins = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image_head);
        dest.writeString(image_shirt);
        dest.writeString(image_legs);
        dest.writeInt(total_score);
        dest.writeInt(avg_score);
        dest.writeInt(achievements);
        dest.writeInt(games_played);
        dest.writeInt(jenkyCoins);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getImage_head() {
        return image_head;
    }

    public void setImage_head(String image_head) {
        this.image_head = image_head;
    }

    public String getImage_shirt() {
        return image_shirt;
    }

    public void setImage_shirt(String image_shirt) {
        this.image_shirt = image_shirt;
    }

    public String getImage_legs() {
        return image_legs;
    }

    public void setImage_legs(String image_legs) {
        this.image_legs = image_legs;
    }

    public int getAchievements() {
        return achievements;
    }

    public void setAchievements(int achievements) {
        this.achievements = achievements;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getAvg_score() {
        return avg_score;
    }

    public void setAvg_score(int avg_score) {
        this.avg_score = avg_score;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getJenkyCoins() {
        return jenkyCoins;
    }

    public void setJenkyCoins(int jenkyCoins) {
        this.jenkyCoins = jenkyCoins;
    }
}
