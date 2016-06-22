package com.jenky.codebuddy.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ProjectAdapter;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Commit;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.IntentFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class ProjectFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ProjectAdapter projectAdapter;
    private ArrayList<Project> projects = new ArrayList<>();
    private ListView resultListView;
    private View rootView;
    private LinearLayout main;

    private Callback projectCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
            if(getActivity() != null) {
                JSONArray jsonProjects = result.getJSONArray("activeProjects");
                for(int i = 0; i < jsonProjects.length(); i++){
                    Project project = new Project().init(jsonProjects.getJSONObject(i));
                    projects.add(project);
                }
                if(projects.size() == 0){
                    addNoPorojectMessage();
                }
                projectAdapter.notifyDataSetChanged();
                getActivity().findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onFailed(JSONObject result) throws JSONException {
            if(getActivity() != null) {
                Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
                getActivity().findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);
            }
        }

        private void addNoPorojectMessage(){
            TextView noItems = new TextView(getActivity());
            noItems.setText(R.string.no_projects);
            main.removeAllViews();
            main.addView(noItems);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_project, container, false);
        main = (LinearLayout) rootView.findViewById(R.id.main);
        resultListView = (ListView) rootView.findViewById(R.id.result_list_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        projectAdapter = new ProjectAdapter(getContext(), R.layout.component_project, projects);
        resultListView.setAdapter(projectAdapter);
        resultListView.setOnItemClickListener(this);
        getActivity().findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        Request.getProjects(projectCallback);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Project project = projects.get(position);
        gotoTowers(project);
    }

    /**
     * Open the Tower View
     * @param project The project it should create towers for
     */
    private void gotoTowers(Project project) {
            Intent intent = IntentFactory.getTowerIntent(getActivity());
            intent.putExtra("projectId", project.getId());
            startActivity(intent);
    }
}
