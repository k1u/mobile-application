package com.jenky.codebuddy.api;

import android.os.AsyncTask;
import android.util.Log;

import com.jenky.codebuddy.models.Project;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Fabian on 28-4-2016.
 */
public class ProjectApi extends AsyncTask<Void, Void, Project> {

    @Override
    protected Project doInBackground(Void... params) {
       return (Project) HttpRequestTask.connect("http://jenky.azurewebsites.net/score", Project.class);
    }

    @Override
    protected void onPostExecute(Project project) {
        project.setName(Integer.toString(project.getId()));
        project.setId(project.getId());
    }
}
