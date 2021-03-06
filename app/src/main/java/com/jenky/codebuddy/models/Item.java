package com.jenky.codebuddy.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class Item implements Parcelable {
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    private int id;
    private String name;
    private String image;
    private String type;
    private int price;

    public Item() {
        //Empty for initial creation
    }

    public Item(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readString();
        type = in.readString();
        price = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(type);
        dest.writeDouble(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Item init(JSONObject json) throws JSONException {
        id = json.getInt("id");
        name = json.getString("name");
        type = json.getString("type");
        image = json.getString("image");
        price = json.getInt("price");
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
