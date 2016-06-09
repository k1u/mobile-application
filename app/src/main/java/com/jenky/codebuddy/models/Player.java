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
    private Item head;
    private Item shirt;
    private Item legs;
    private Item block;
    private int totalScore;
    private int avgScore;
    private int achievements;
    private int gamesPlayed;
    private int jenkyCoins;



    public Player(){
        //Empty for initial creation
    }

    public Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        head = in.readParcelable(Item.class.getClassLoader());
        shirt = in.readParcelable(Item.class.getClassLoader());
        legs = in.readParcelable(Item.class.getClassLoader());
        block = in.readParcelable(Item.class.getClassLoader());
        totalScore = in.readInt();
        avgScore = in.readInt();
        achievements = in.readInt();
        gamesPlayed = in.readInt();
        jenkyCoins = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(head, 0);
        dest.writeParcelable(shirt, 0);
        dest.writeParcelable(legs, 0);
        dest.writeParcelable(block, 0);
        dest.writeInt(totalScore);
        dest.writeInt(avgScore);
        dest.writeInt(achievements);
        dest.writeInt(gamesPlayed);
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

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getShirt() {
        return shirt;
    }

    public void setShirt(Item shirt) {
        this.shirt = shirt;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(Item legs) {
        this.legs = legs;
    }

    public int getAchievements() {
        return achievements;
    }

    public void setAchievements(int achievements) {
        this.achievements = achievements;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getJenkyCoins() {
        return jenkyCoins;
    }

    public void setJenkyCoins(int jenkyCoins) {
        this.jenkyCoins = jenkyCoins;
    }

    public Item getBlock() {
        return block;
    }

    public void setBlock(Item block) {
        this.block = block;
    }
}
