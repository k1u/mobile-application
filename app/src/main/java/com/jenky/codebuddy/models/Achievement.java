package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JTLie on 25-4-2016.
 */

public class Achievement implements Parcelable{
    public static final Parcelable.Creator<Achievement> CREATOR = new Parcelable.Creator<Achievement>() {
        public Achievement createFromParcel(Parcel in) {
            return new Achievement(in);
        }

        public Achievement[] newArray(int size) {
            return new Achievement[size];
        }
    };

    private int id;
    private String name;
    private String image;
    private String description;
    private String reward;
    private double complete;

    public Achievement() {
        //Empty for initial creation
    }

    public Achievement(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readString();
        description = in.readString();
        reward = in.readString();
        complete = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(description);
        dest.writeString(reward);
        dest.writeDouble(complete);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Achievement init(JSONObject json) throws JSONException {
        return this;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public double getComplete_percentage() {
        return complete;
    }

    public void setComplete_percentage(double completePercentage) {
        this.complete = completePercentage;
    }
}
