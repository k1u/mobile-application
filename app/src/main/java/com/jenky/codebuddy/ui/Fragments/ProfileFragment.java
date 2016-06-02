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

import com.android.volley.VolleyError;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.Converters;
import com.jenky.codebuddy.util.TestData;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {

    private HistoryAdapter historyAdapter;
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();
    private ListView resultListView;
    private RelativeLayout avatar;
    private ImageView head,
            shirt,
            legs;
    private Converters converters;
    private TextView
            totalScoreValue,
            avgScoreValue,
            achievementsValue,
            gamesPlayedValue;
    private View rootView;
    private Player player;

    private Callback playerCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO result into player
        }

        @Override
        public void onFailed(VolleyError error) {

        }
    };

    private Callback historyCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO process results
        }

        @Override
        public void onFailed(VolleyError error) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        setViews();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        historyAdapter = new HistoryAdapter(getContext(), R.layout.component_history, projects);
        resultListView.setAdapter(historyAdapter);
        resultListView.setOnItemClickListener(this);
        converters = new Converters(getActivity());

        setOnClickListeners();
        //TODO remove test Data
        TestData.addTestProjects(projects);
        player = TestData.testPlayer();
        Request.getPlayer(playerCallback);
        Request.getHistory(historyCallback);
        //TODO move addStats() to okayerCallback
        addStats();
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
        totalScoreValue = (TextView) rootView.findViewById(R.id.total_score_value);
        avgScoreValue = (TextView) rootView.findViewById(R.id.avg_score_value);
        achievementsValue = (TextView) rootView.findViewById(R.id.achievements_value);
        gamesPlayedValue = (TextView) rootView.findViewById(R.id.games_played_value);
        avatar = (RelativeLayout) rootView.findViewById(R.id.avatar_layout);
    }


    private void addStats() {
        totalScoreValue.setText(Integer.toString(player.getTotal_score()));
        avgScoreValue.setText(Integer.toString(player.getAvg_score()));
        achievementsValue.setText(Integer.toString(player.getAchievements()));
        gamesPlayedValue.setText(Integer.toString(player.getGames_played()));
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

    private void setOnClickListeners() {
        avatar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //TODO remove tests

                TestData.addTestHelmets(itemList);
                TestData.addTestShirts(itemList);
                TestData.addTestLegs(itemList);
                TestData.addTestBlocks(itemList);
                EquipmentFragment equipmentFragment = new EquipmentFragment();

                FragmentManager fm = getFragmentManager();
                Bundle args = new Bundle();
                args.putParcelableArrayList("items", itemList);
                equipmentFragment.setArguments(args);
                equipmentFragment.show(fm, "Dialog Fragment");
            }
        });
    }


}
