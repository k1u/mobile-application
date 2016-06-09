package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JTLie on 20-5-2016.
 */

public class Tower implements Parcelable {
    public static final Parcelable.Creator<Tower> CREATOR = new Parcelable.Creator<Tower>() {
        public Tower createFromParcel(Parcel in) {
            return new Tower(in);
        }

        public Tower[] newArray(int size) {
            return new Tower[size];
        }
    };

    private int score;
    private int height;
    private Player player;

    public Tower() {
        //Empty for initial creation
    }

    public Tower(Parcel in) {
        score = in.readInt();
        height = in.readInt();
        player = in.readParcelable(Player.class.getClassLoader());

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(score);
        dest.writeInt(height);
        dest.writeParcelable(player, 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Tower init(JSONObject json) throws JSONException {
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
