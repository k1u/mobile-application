package com.jenky.codebuddy.util;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by JTLie on 25-5-2016.
 */
public class AppContext  extends Application {
    private static Context context;
    private Preferences preferences;
    private Picasso mImageLoader;

    public static AppContext instance() {
        return (AppContext) context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("AppContext", "created");
        context = getApplicationContext();
        preferences = new Preferences(context);
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public Picasso getImageLoader() {
        if (mImageLoader == null) {
            initImageLoader();
        }
        return mImageLoader;
    }

    private void initImageLoader() {
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this) {
            @Override
            protected HttpURLConnection openConnection(Uri uri) throws IOException {
                HttpURLConnection connection = super.openConnection(uri);
                return connection;
            }
        });
        mImageLoader = builder.build();
    }
}
