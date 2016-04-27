package com.jenky.codebuddy.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JTLie on 25-4-2016.
 */
public class Project /*implements Parcelable */{

/*    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        public Project[] newArray(int size) {
            return new Project[size];
        }
    };*/

/*    private Context mContext;
    private LayoutInflater inflater;*/

    private String name;
    private int id;
    private int score;
    private String status;
    private Calendar createdOn;
    private int members;
    private String rank;

/*    public Project() {
    }


    public Project(Parcel in) {
        id = in.readInt();
        name = in.readString();
        score = in.readInt();
        status = in.readString();

        rank = in.readString();
        createdOn = (Calendar) in.readSerializable();
        members = in.readInt();
    }*/

    /*@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(score);
        dest.writeString(status);
        dest.writeString(rank);
        dest.writeSerializable(createdOn);
        dest.writeInt(members);
    }

    public Project init(String jsonString) throws JSONException {
        init(new JSONObject(jsonString));
        return this;
    }

    public Project init(JSONObject json) throws JSONException {

        return this;
    }*/

/*    public Project setContext(Context context) {
        mContext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return this;
    }

    public int describeContents() {
        return 0;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
