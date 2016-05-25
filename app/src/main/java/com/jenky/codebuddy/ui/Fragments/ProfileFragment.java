package com.jenky.codebuddy.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.models.Tower;
import com.jenky.codebuddy.util.Converters;
import com.jenky.codebuddy.util.TestData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {

    private HistoryAdapter historyAdapter;
    private ArrayList<Project> projects = new ArrayList<>();
    private ListView resultListView;
    private RelativeLayout avatar;
    private ImageView head,
            shirt,
            legs;
    private Converters converters;
    private TextView totalScore,
            avgScore,
            achievments,
            gamesPlayed,
            totalScoreValue,
            avgScoreValue,
            achievementsValue,
            gamesPlayedValue;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        setViews();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
/*        try {
            Project project = new ProjectApi().execute().get();
            projects.add(project);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            Toast.makeText(getContext(), "Failed to receive", Toast.LENGTH_SHORT);
        }*/
        super.onActivityCreated(savedInstanceState);
        historyAdapter = new HistoryAdapter(getContext(), R.layout.component_history, projects);
        resultListView.setAdapter(historyAdapter);
        resultListView.setOnItemClickListener(this);
        TestData.addTestProjects(projects);
        converters = new Converters(getActivity());
        addTestStats();
        setOnClickListeners();
        //TODO Fill array adapter


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Project project = projects.get(position);
        gotoProjectStats(project);
    }

    private void gotoProjectStats(Project project) {
        //TODO Ga naar Project Activity (Towers)
    }

    private void setViews() {
        resultListView = (ListView) rootView.findViewById(R.id.result_list_view);
        totalScore = (TextView) rootView.findViewById(R.id.total_score_label);
        totalScoreValue = (TextView) rootView.findViewById(R.id.total_score_value);
        avgScore = (TextView) rootView.findViewById(R.id.avg_score_label);
        avgScoreValue = (TextView) rootView.findViewById(R.id.avg_score_value);
        achievments = (TextView) rootView.findViewById(R.id.achievements_label);
        achievementsValue = (TextView) rootView.findViewById(R.id.achievements_value);
        gamesPlayed = (TextView) rootView.findViewById(R.id.games_played_label);
        gamesPlayedValue = (TextView) rootView.findViewById(R.id.games_played_value);
        avatar = (RelativeLayout) rootView.findViewById(R.id.avatar_layout);
    }


    private void addTestStats() {
        totalScoreValue.setText("75433");
        avgScoreValue.setText("6372");
        achievementsValue.setText("12");
        gamesPlayedValue.setText("11");
        setTestAvater();
    }


    private void setTestAvater() {
        head = new ImageView(getActivity());
        shirt = new ImageView(getActivity());
        legs = new ImageView(getActivity());
        head.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.test_head2));
        shirt.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.test_shirt2));
        legs.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.test_legs2));
        head.setLayoutParams(getHeadParams());
        shirt.setLayoutParams(getShirtParams());
        legs.setLayoutParams(getLegsParams());
        avatar.addView(head);
        avatar.addView(shirt);
        avatar.addView(legs);
    }

    private RelativeLayout.LayoutParams getHeadParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(4),
                0,
                0,
                0
        );
        return params;
    }

    private RelativeLayout.LayoutParams getShirtParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                0,
                converters.getInDp(36),
                0,
                0
        );
        return params;
    }

    private RelativeLayout.LayoutParams getLegsParams() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(11),
                converters.getInDp(67),
                0,
                0
        );
        return params;
    }

    private void setOnClickListeners(){
        avatar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EquipmentFragment equipmentFragment = new EquipmentFragment();
                // Show DialogFragment
                FragmentManager fm = getFragmentManager();
                equipmentFragment.show(fm,"Dialog Fragment");
            }
        });

    }
}
