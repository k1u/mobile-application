package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Calendar;

public class Commit implements Parcelable {
    public static final Parcelable.Creator<Commit> CREATOR = new Parcelable.Creator<Commit>() {
        public Commit createFromParcel(Parcel in) {
            return new Commit(in);
        }
        public Commit[] newArray(int size) {
            return new Commit[size];
        }
    };

    private int id;
    private int score;
    private String projectName;
    private String branch;
    private Calendar createdOn;

    public Commit() {
        //Empty for initial creation
    }

    public Commit(Parcel in) {
        id = in.readInt();
        projectName = in.readString();
        score = in.readInt();
        branch = in.readString();
        createdOn = (Calendar) in.readSerializable();
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(projectName);
        dest.writeInt(score);
        dest.writeString(branch);
        dest.writeSerializable(createdOn);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    public Commit init(JSONObject json) throws JSONException {
        id = json.getInt("id");
        createdOn = Calendar.getInstance();
        createdOn.setTimeInMillis(json.getLong("created_at"));
        branch = json.getString("branch");
        score = json.getInt("score");
        projectName = json.getString("projectName");
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
