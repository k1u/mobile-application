package com.jenky.codebuddy.ui;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.service.ProjectApi;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {

    private HistoryAdapter historyAdapter;
    private ArrayList<Project> Projects = new ArrayList<>();
    private ListView resultListView;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        resultListView = (ListView) rootView.findViewById(R.id.result_list_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        new HttpRequestTask().execute();
        super.onActivityCreated(savedInstanceState);
        historyAdapter = new HistoryAdapter(getContext(), R.layout.component_history, Projects);
        resultListView.setAdapter(historyAdapter);
        resultListView.setOnItemClickListener(this);

        //TODO Fill array adapter
        //TEST
//        for(int i = 0; i < 5; i++){
//            Project project = new Project();
//            project.setName("name" + i);
//            project.setScore(i);
//            project.setRank("Rank" + i);
//            project.setStatus("Status" + i);
//            Projects.add(project);
//        }


    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Project> {
        @Override
        protected Project doInBackground(Void... params) {
            try {
                final String url = "http://jenky.azurewebsites.net/score";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Project project = restTemplate.getForObject(url, Project.class);
                return project;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Project project) {

            project.setName(Integer.toString(project.getId()));
            project.setId(project.getId());

            Projects.add(project);
            historyAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Project project = Projects.get(position);
        gotoLocationDetail(project);
    }

    private void gotoLocationDetail(Project project) {
        //TODO Ga naar Project Activity (Towers)
    }
}
