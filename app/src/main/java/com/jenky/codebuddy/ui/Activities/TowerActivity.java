package com.jenky.codebuddy.ui.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.customViews.HorizontalScroll;
import com.jenky.codebuddy.customViews.VerticalScroll;
import com.jenky.codebuddy.models.Tower;
import com.jenky.codebuddy.util.Converters;

import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TowerActivity extends Activity {

    private float mx, my;
    private ScrollView vScroll;
    private HorizontalScrollView hScroll;
    private LinearLayout backgroundLinearLayout, globalTowerLayout;
    private ArrayList<Tower> towers = new ArrayList<>();
    private final int towerPerBackground = 9;
    private final int towerMagrinLeft = 20;
    private final int towerMagrinRight = 0;
    private final int towerMagrinTop = 0;
    private final int towerMagrinBottom = 0;
    private final Converters converters = new Converters(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower);
        setLayouts();
        scrollDown(vScroll);
        addTestTowers();
        drawActivity();
    }

    private void setLayouts() {
        vScroll = (VerticalScroll) findViewById(R.id.vScroll);
        hScroll = (HorizontalScroll) findViewById(R.id.hScroll);
        backgroundLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_backgrounds);
        globalTowerLayout = (LinearLayout) findViewById(R.id.linear_layout_towers);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float curX, curY;

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mx = event.getX();
                my = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                curX = event.getX();
                curY = event.getY();
                vScroll.scrollBy((int) (mx - curX), (int) (my - curY));
                hScroll.scrollBy((int) (mx - curX), (int) (my - curY));
                mx = curX;
                my = curY;
                break;
            case MotionEvent.ACTION_UP:
                curX = event.getX();
                curY = event.getY();
                vScroll.scrollBy((int) (mx - curX), (int) (my - curY));
                hScroll.scrollBy((int) (mx - curX), (int) (my - curY));
                break;
        }
        return true;
    }

    private void scrollDown(ScrollView s) {
        final ScrollView scrollView = s;
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        }, 1000);
    }

    private void drawActivity() {
        drawBackground(towers.size());
        drawTowers(towers);
    }

    private void drawBackground(double towerAmount) {

        int backgroundAmount = (int) Math.ceil(towerAmount / towerPerBackground);

        for (int i = 0; i < backgroundAmount; i++) {
            backgroundLinearLayout.addView(getBackgroundImage());
        }
    }

    private void drawTowers(ArrayList<Tower> towers) {
        for (int i = 0; i < towers.size(); i++) {
            Tower tower = towers.get(i);
            LinearLayout towerLayout = getTowerLayout();
            for (int j = 0; j < tower.getHeight(); j++) {
                towerLayout.addView(getTowerBlock(tower.getBlock()));
            }

            globalTowerLayout.addView(towerLayout);
        }
    }

    private void addTestTowers() {
        for (int i = 0; i < 30; i++) {
            Tower tower = new Tower();
            tower.setHeight(i + 1);
            tower.setId(i + 1);
            tower.setScore(i * 1000);
            tower.setBlock("http://imgur.com/b80yEkL");
            towers.add(tower);
        }
    }

    private ImageView getBackgroundImage() {
        ImageView background = new ImageView(this);
        background.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        background.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.background1));

        return background;
    }

    private LinearLayout getTowerLayout() {
        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.ALIGN_PARENT_BOTTOM);

        params.setMargins(
                converters.getInDp(towerMagrinLeft),
                converters.getInDp(towerMagrinTop),
                converters.getInDp(towerMagrinRight),
                converters.getInDp(towerMagrinBottom)
        );
        params.gravity = (Gravity.BOTTOM);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        return linearLayout;
    }

    private ImageView getTowerBlock(String BlockUrl )   {
        ImageView block = new ImageView(this);
        block.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));


        //TODO load tower block image instead.

       /* try {
            URL url = new URL(BlockUrl);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            block.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

         block.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),  R.drawable.test_block));
        return block;
    }
}
