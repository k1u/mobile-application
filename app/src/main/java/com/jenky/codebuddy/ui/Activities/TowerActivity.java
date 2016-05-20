package com.jenky.codebuddy.ui.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.customViews.HorizontalScroll;
import com.jenky.codebuddy.customViews.VerticalScroll;
import com.jenky.codebuddy.models.Tower;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class TowerActivity extends Activity {

    private float mx, my;
    private ScrollView vScroll;
    private HorizontalScrollView hScroll;
    private LinearLayout backgroundLinearLayout, towerLinearLayout;
    private ArrayList<Tower> towers = new ArrayList<>();
    private final int TowerPerBackground = 9;


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
        towerLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_towers);
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

        int backgroundAmount = (int) Math.ceil(towerAmount / TowerPerBackground);

        for (int i = 0; i < backgroundAmount; i++) {
            backgroundLinearLayout.addView(getBackgroundImage());
        }
    }

    private void drawTowers(ArrayList<Tower> towers) {
        for(int i = 0; i < towers.size(); i++){
            int towerSize = towers.get(i).getHeight();
        }
    }

    private void addTestTowers() {
        for (int i = 0; i < 30; i++) {
            Tower tower = new Tower();
            tower.setHeight(i * 7 + 1);
            tower.setId(1 + 1);
            tower.setBlock(ContextCompat.getDrawable(getApplicationContext(), R.drawable.test_block));
            tower.setScore(i * 1000);
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
}
