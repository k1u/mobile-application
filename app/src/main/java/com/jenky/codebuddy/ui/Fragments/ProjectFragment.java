package com.jenky.codebuddy.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ProjectAdapter;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.IntentFactory;
import com.jenky.codebuddy.util.TestData;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Jason on 26-Apr-16.
 */
public class ProjectFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ProjectAdapter projectAdapter;
    private ArrayList<Project> projects = new ArrayList<>();
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
        projectAdapter = new ProjectAdapter(getContext(), R.layout.component_project, projects);
        resultListView.setAdapter(projectAdapter);
        resultListView.setOnItemClickListener(this);

        TestData.addTestProjects(projects);
        //TEST
        projectAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Project project = projects.get(position);
        gotoTowers(project);
    }

    private void gotoTowers(Project project) {
            Intent intent = IntentFactory.getTowerIntent(getActivity());
            startActivity(intent);

    }
}
