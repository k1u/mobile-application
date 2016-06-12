package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.AchievementAdapter;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.TestData;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Jason on 26-Apr-16.
 */
public class AchievementFragment extends Fragment {

    private AchievementAdapter achievementAdapter;
    private ArrayList<Achievement> achievements = new ArrayList<>();
    private ListView resultListView;
    private View rootView;

    private Callback achievementCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO process results
            getActivity().findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);
        }

        public void onFailed(JSONObject result) throws JSONException {
            if(getActivity() != null) {
                Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
                //TODO remove test
                TestData.addTestAchievements(achievements);
                achievementAdapter.notifyDataSetChanged();
                getActivity().findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);
            }
        }

    };


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
        achievementAdapter = new AchievementAdapter(getContext(), R.layout.component_project, achievements);
        resultListView.setAdapter(achievementAdapter);
        getActivity().findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        Request.getAchievements(achievementCallback);
    }

}
