package com.jenky.codebuddy.ui.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.custom.HorizontalScroll;
import com.jenky.codebuddy.custom.VerticalScroll;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.models.Tower;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Converters;
import com.jenky.codebuddy.util.TestData;
import com.squareup.picasso.Picasso;

import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TowerActivity extends AppCompatActivity {

    private float xCoordinate,
            yCoordinate;
    private ScrollView vScroll;
    private HorizontalScrollView hScroll;
    private LinearLayout backgroundLinearLayout,
            globalTowerLayout;
    private ArrayList<Tower> towers = new ArrayList<>();
    private final static int towerPerBackground = 7;
    private final static int towerMagrinLeft = 20;
    private final static int towerMagrinRight = 0;
    private final static int towerMagrinTop = 0;
    private final static int towerMagrinBottom = 0;
    private final Converters converters = new Converters(this);
    private Toolbar toolbar;
    private Callback towerCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {

            //TODO fill tower array
        }
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower);
        setViews();

        setActionBar();
        scrollDown(vScroll);
        //TODO remove Test data
        TestData.addTestTowers(towers);
        //TODO move draw Activity to towerCallback  success
        drawActivity();
        //Request.getTower(towerCallback, getIntent().getIntExtra("projectId", -1));

    }

    private void setViews() {
        vScroll = (VerticalScroll) findViewById(R.id.vertical_scroll);
        hScroll = (HorizontalScroll) findViewById(R.id.horizontal_scroll);
        backgroundLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_backgrounds);
        globalTowerLayout = (LinearLayout) findViewById(R.id.linear_layout_towers);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Lets user scroll on both axis at the same time
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xCoordinate = event.getX();
                yCoordinate = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                vScroll.scrollBy((int) (xCoordinate - event.getX()), (int) (yCoordinate - event.getY()));
                hScroll.scrollBy((int) (xCoordinate - event.getX()), (int) (yCoordinate - event.getY()));
                xCoordinate = event.getX();
                yCoordinate = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                vScroll.scrollBy((int) (xCoordinate -  event.getX()), (int) (yCoordinate - event.getY()));
                hScroll.scrollBy((int) (xCoordinate -  event.getX()), (int) (yCoordinate - event.getY()));
                break;
            default:

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
            towerLayout.addView(drawAvatar(towers.get(i).getPlayer()));
            for (int j = 0; j < tower.getHeight(); j++) {
                towerLayout.addView(getTowerBlock(tower.getPlayer().getBlock().getImage()));
            }
            globalTowerLayout.addView(towerLayout);
        }
    }

    private RelativeLayout drawAvatar(Player player) {
        RelativeLayout avatarLayout = new RelativeLayout(this);

        ImageView head = new ImageView(this);
        ImageView shirt = new ImageView(this);
        ImageView legs = new ImageView(this);
        Picasso.with(this)
                .load(player.getHead().getImage())
                .placeholder(R.drawable.test_head2)
                .into(head);
        Picasso.with(this)
                .load(player.getShirt().getImage())
                .placeholder(R.drawable.test_shirt2)
                .into(shirt);
        Picasso.with(this)
                .load(player.getLegs().getImage())
                .placeholder(R.drawable.test_legs2)
                .into(legs);

        head.setLayoutParams(getAvatarParams(10, 0, 0, 0));
        shirt.setLayoutParams(getAvatarParams(7, 24, 0, 0));
        legs.setLayoutParams(getAvatarParams(12, 45, 0, 0));

        avatarLayout.addView(head);
        avatarLayout.addView(shirt);
        avatarLayout.addView(legs);
        return avatarLayout;
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
        params.gravity = Gravity.BOTTOM;
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }

    private RelativeLayout.LayoutParams getAvatarParams(int marginLeft, int marginTop, int marginRight, int marginBottom) {

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(
                converters.getInDp(marginLeft),
                converters.getInDp(marginTop),
                converters.getInDp(marginRight),
                converters.getInDp(marginBottom));

        return params;
    }

    private ImageView getTowerBlock(String blockUrl) {
        
        ImageView block = new ImageView(this);
        block.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        Picasso.with(this)
                .load(blockUrl)
                .fit()
                .placeholder(R.drawable.test_block)
                .into(block);
        
        return block;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
