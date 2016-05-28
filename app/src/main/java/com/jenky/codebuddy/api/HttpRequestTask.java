package com.jenky.codebuddy.api;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;



/**
 * Created by Fabian on 28-4-2016.
 */
class HttpRequestTask {

    private HttpRequestTask(){
        //not called
    }

    public static Object connect(String url, Class c) {
            Object obj;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            obj = restTemplate.getForObject(url, c);
            return obj;
    }
}
