package com.jenky.codebuddy.ui.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.custom.HorizontalScroll;
import com.jenky.codebuddy.custom.VerticalScroll;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.models.Tower;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Utilities;
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

    private static final int TOWER_PER_BACKGROUND = 7;
    private static final int TOWER_MAGRIN_LEFT = 20;
    private static final int TOWER_MAGRIN_RIGHT = 0;
    private static final int TOWER_MAGRIN_TOP = 0;
    private static final int TOWER_MAGRIN_BOTTOM = 0;
    private float xCoordinate;
    private float yCoordinate;
    private ScrollView vScroll;
    private HorizontalScrollView hScroll;
    private LinearLayout backgroundLinearLayout;
    private LinearLayout globalTowerLayout;
    private ArrayList<Tower> towers = new ArrayList<>();
    private Toolbar toolbar;
    private Callback towerCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO add towers
            drawActivity();
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
        Request.getTowers(towerCallback, getIntent().getIntExtra("projectId", -1));
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
                vScroll.scrollBy((int) (xCoordinate - event.getX()), (int) (yCoordinate - event.getY()));
                hScroll.scrollBy((int) (xCoordinate - event.getX()), (int) (yCoordinate - event.getY()));
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

    /**
     * Draws a certain amount of background depending on the amount of towers
     * @param towerAmount The amount of Towers for this View
     */
    private void drawBackground(double towerAmount) {
        int backgroundAmount = (int) Math.ceil(towerAmount / TOWER_PER_BACKGROUND);
        for (int i = 0; i < backgroundAmount; i++) {
            backgroundLinearLayout.addView(getBackgroundImage());
        }
    }

    /**
     * Add ImageViews to create the Towers
     * @param towers List of Tower Objects
     */
    private void drawTowers(ArrayList<Tower> towers) {
        for (int i = 0; i < towers.size(); i++) {
            Tower tower = towers.get(i);
            LinearLayout towerLayout = getTowerLayout();
            towerLayout.addView(drawAvatar(towers.get(i).getPlayer()));
            ImageView blockImage = getTowerBlock(tower.getPlayer().getBlock().getImage());
            for (int j = 0; j < tower.getHeight(); j++) {
                ImageView block = new ImageView(this);
                block.setImageDrawable(blockImage.getDrawable());
                towerLayout.addView(block);
            }
            globalTowerLayout.addView(towerLayout);
        }
    }

    /**
     * Gets the Images from the Player Object and draws them with
     * the appropriate parameters.
     * @param player Player Object it needs to draw
     * @return The RelativeLayout with the Avatar ImageViews
     */
    private RelativeLayout drawAvatar(Player player) {
        RelativeLayout avatarLayout = new RelativeLayout(this);

        ImageView head = new ImageView(this);
        ImageView shirt = new ImageView(this);
        ImageView legs = new ImageView(this);
        Picasso.with(this).load(player.getHelmet().getImage())
                .fit()
                .placeholder(R.drawable.default_head)
                .into(head);
        Picasso.with(this)
                .load(player.getShirt().getImage())
                .fit()
                .placeholder(R.drawable.default_shirt)
                .into(shirt);
        Picasso.with(this)
                .load(player.getLegs().getImage())
                .fit()
                .placeholder(R.drawable.default_legs)
                .into(legs);

        head.setLayoutParams(Utilities.getLayoutParams(this, 20, 22,10, 10, 0, 0));
        shirt.setLayoutParams(Utilities.getLayoutParams(this, 24, 18,7, 28, 0, 0));
        legs.setLayoutParams(Utilities.getLayoutParams(this, 17, 12,12, 45, 0, 0));
        avatarLayout.addView(head);
        avatarLayout.addView(shirt);
        avatarLayout.addView(legs);
        return avatarLayout;
    }

    /**
     * Create a ImageView which containt the background Image and the appropriate parameters
     * @return The Background Image
     */
    private ImageView getBackgroundImage() {
        ImageView background = new ImageView(this);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        background.setLayoutParams(Utilities.getLayoutParams(this, 700, 600, 0, 0, 0, 0));
        background.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.background1));
        return background;
    }

    /**
     * @return a LinearLayout with the appropriate params
     * for the Tower ImageViews to be placed it.
     */
    private LinearLayout getTowerLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.ALIGN_PARENT_BOTTOM);

        params.setMargins(
                Utilities.getInDp(this, TOWER_MAGRIN_LEFT),
                Utilities.getInDp(this, TOWER_MAGRIN_TOP),
                Utilities.getInDp(this, TOWER_MAGRIN_RIGHT),
                Utilities.getInDp(this, TOWER_MAGRIN_BOTTOM)
        );
        params.gravity = Gravity.BOTTOM;
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }

    /**
     * Create a ImageView which contains the right image to build the tower.
     * @param blockUrl url of the image it should load
     * @return ImageView which contains the image form the url
     */
    private ImageView getTowerBlock(String blockUrl) {
        ImageView block = new ImageView(this);
        block.setLayoutParams(Utilities.getLayoutParams(this, 45, 16, 0, 0, 0, 0));
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
