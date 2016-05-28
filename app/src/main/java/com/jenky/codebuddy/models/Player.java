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
    private String image;

    public Player(){
        //Empty for initial creation
    }

    public Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
