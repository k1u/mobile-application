package com.jenky.codebuddy.api;


import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Fabian on 28-4-2016.
 */
public abstract class HttpRequestTask extends AsyncTask<String, Void, Void> {

    // HTTP POST request
    public static void sendPost() throws Exception {
        //URL url = new URL(Preferences.serverUrl+"/signup");
        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setChunkedStreamingMode(0);
        OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        urlConnection.disconnect();
    }

    public static String executeRequest() throws IOException {
        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
       // urlConnection.setRequestProperty("sessionToken", AppController.getInstance().getPreferences().getToken());
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        urlConnection.disconnect();
        return in.toString();
    }
}
