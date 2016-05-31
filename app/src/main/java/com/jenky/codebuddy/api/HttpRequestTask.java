package com.jenky.codebuddy.api;


import com.jenky.codebuddy.util.Preferences;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.InputStream;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Fabian on 28-4-2016.
 */
public class HttpRequestTask {

    private HttpRequestTask() {
        //not called
    }

    public static void sendGet() throws Exception {
        URL url = new URL(Preferences.serverUrl+"/signup");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        urlConnection.disconnect();
    }

    // HTTP POST request
    public static void sendPost() throws Exception {
        URL url = new URL(Preferences.serverUrl+"/signup");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        urlConnection.disconnect();
    }

}
