package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;


/**
 * Created by JTLie on 25-4-2016.
 */
public class Project implements Parcelable {
    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

/*    private Context mContext;
    private LayoutInflater inflater;*/



    private int id;
    private String name;
    private int score;
    private String status;
    private Calendar createdOn;
    private int members;
    private int rank;

    public Project() {
        //Empty for initial creation
    }

    public Project(Parcel in) {
        id = in.readInt();
        name = in.readString();
        score = in.readInt();
        status = in.readString();
        createdOn = (Calendar) in.readSerializable();
        members = in.readInt();
        rank = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(score);
        dest.writeString(status);
        dest.writeSerializable(createdOn);
        dest.writeInt(members);
        dest.writeInt(rank);
    }

    public int describeContents() {
        return 0;
    }
/*
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
*/

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
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
