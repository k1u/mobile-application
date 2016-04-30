package com.jenky.codebuddy.api;

import android.os.AsyncTask;
import android.util.Log;

import com.jenky.codebuddy.models.Project;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * Created by Fabian on 28-4-2016.
 */
public class HttpRequestTask {

    public static Object connect(String url, Class c) {

        try {
            Object obj = c.newInstance();
            //Constructor<?> constructor = c.getConstructor(c);
            //Object object = constructor.newInstance(new Objects())
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            obj = restTemplate.getForObject(url, c);
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
