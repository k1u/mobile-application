package com.jenky.codebuddy.ui.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ShopAdapter;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Preferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private Button logOut;
    private TextView jenkyCoins;
    private ArrayList<Item> items = new ArrayList<>();
    private ProgressBar progressBar;
    private Callback itemCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
            JSONArray jsonArray = result.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                Item item = new Item().init(jsonArray.getJSONObject(i));
                items.add(item);
            }
            setTabs();
            jenkyCoins.setText(result.getString("jenkycoins"));
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }

        private void setTabs() {
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPager.setAdapter(new ShopAdapter(getSupportFragmentManager(),
                    ShopActivity.this));
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(viewPager);
        }
    };

    private static Callback purchaseCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO notify user
        }
        @Override
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setTitle(getString(R.string.shop));
        setViews();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar.setVisibility(View.VISIBLE);
        Request.getShop(itemCallback);
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

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (Button) findViewById(R.id.log_out);
        logOut.setOnClickListener(this);
        jenkyCoins = (TextView) findViewById(R.id.jenkey_coins);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.log_out:
                Preferences.logOut(ShopActivity.this);
                finish();
                break;
            default:
                Log.e("onClick", getString(R.string.unknown_id));
                break;
        }
    }

    public static void purchaseItem(Item item) {
        Request.getPurchase(purchaseCallback, item.getId());
    }

    public static void purchaseAlert(final Context context, final Item item) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(context.getString(R.string.purchase_alert));
        alertDialog.setMessage(item.getName());
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ShopActivity.purchaseItem(item);
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public List<Item> getItems() {
        return items;
    }
}



