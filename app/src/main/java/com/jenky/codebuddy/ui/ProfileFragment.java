package com.jenky.codebuddy.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ProjectItemAdapter;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.IntentFactory;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ProjectItemAdapter projectAdapter;
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
        super.onActivityCreated(savedInstanceState);
        projectAdapter = new ProjectItemAdapter(getContext(), R.layout.component_project, Projects);
        resultListView.setAdapter(projectAdapter);
        resultListView.setOnItemClickListener(this);

        //TEST
        for(int i = 0; i < 5; i++){
            Project project = new Project();
            project.setName("name" + i);
            project.setScore(i);
            project.setRank("Rank" + i);
            project.setStatus("Status" + i);
            Projects.add(project);
        }

        projectAdapter.notifyDataSetChanged();
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
