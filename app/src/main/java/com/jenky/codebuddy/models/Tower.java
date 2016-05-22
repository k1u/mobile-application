package com.jenky.codebuddy.models;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by JTLie on 20-5-2016.
 */
public class Tower {


    private int score;
    private int height;
    private Player player;
    private String block;


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
