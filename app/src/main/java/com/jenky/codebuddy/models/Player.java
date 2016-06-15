package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private Item helmet = new Item();
    private Item shirt = new Item();
    private Item legs  = new Item();
    private Item block = new Item();
    private int totalScore = 0;
    private int avgScore = 0;
    private int achievements  = 0;
    private int gamesPlayed = 0;
    private int jenkyCoins = 0;

    public Player(){
        //Empty for initial creation
    }

    public Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        helmet = in.readParcelable(Item.class.getClassLoader());
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
        dest.writeParcelable(helmet, 0);
        dest.writeParcelable(shirt, 0);
        dest.writeParcelable(legs, 0);
        dest.writeParcelable(block, 0);
        dest.writeInt(totalScore);
        dest.writeInt(avgScore);
        dest.writeInt(achievements);
        dest.writeInt(gamesPlayed);
        dest.writeInt(jenkyCoins);
    }

    public Player init(JSONObject json) throws JSONException {
        totalScore = json.getInt("totalScore");
        avgScore = (int) json.getDouble("avgScore");
        achievements = json.getInt("achievementCount");
        gamesPlayed = json.getInt("projectCount");
        JSONArray equippedItems = json.getJSONArray("equippedItems");
        setEquipment(equippedItems);
        return this;
    }

    public Player initTower(JSONObject json) throws JSONException {
        JSONArray equippedItems = json.getJSONArray("equippedItems");
        setEquipment(equippedItems);
        return this;
    }

    public void setEquipment(JSONArray equippedItems) throws JSONException {
        for(int i = 0; i < equippedItems.length(); i++){
            Item item = new Item();
            item.init(equippedItems.getJSONObject(i));
            switch(item.getType()){
                case "helmet":
                    helmet = item;
                    break;
                case "shirt":
                    shirt = item;
                    break;
                case "legs":
                    legs = item;
                    break;
                case "block":
                    block = item;
                    break;
                default:
                    Log.e("Equipment Error", "Unknown equipment type");
            }
        }
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

    public Item getHelmet() {
        return helmet;
    }

    public void setHelmet(Item helmet) {
        this.helmet = helmet;
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
