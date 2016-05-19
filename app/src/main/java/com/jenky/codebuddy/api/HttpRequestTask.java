package com.jenky.codebuddy.api;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;



/**
 * Created by Fabian on 28-4-2016.
 */
public class HttpRequestTask {

    public static Object connect(String url, Class c) {

        try {
            Object obj = c.newInstance();
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
