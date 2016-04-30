package com.jenky.codebuddy.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.adapters.ProjectAdapter;
import com.jenky.codebuddy.models.Project;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Jason on 26-Apr-16.
 */
public class ProjectFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ProjectAdapter projectAdapter;
    private ArrayList<Project> Projects = new ArrayList<>();
    private ListView resultListView;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_project, container, false);
        resultListView = (ListView) rootView.findViewById(R.id.result_list_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        projectAdapter = new ProjectAdapter(getContext(), R.layout.component_project, Projects);
        resultListView.setAdapter(projectAdapter);
        resultListView.setOnItemClickListener(this);

        //TEST
        for(int i = 0; i < 5; i++){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, i);
            Project project = new Project();
            project.setName("name" + i);
            project.setCreatedOn(calendar);
            project.setMembers(i);
            Projects.add(project);
        }
        projectAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Project project = Projects.get(position);
        gotoTowers(project);
    }

    private void gotoTowers(Project project) {
        //TODO Ga naar Project Activity (Towers)
    }
}
