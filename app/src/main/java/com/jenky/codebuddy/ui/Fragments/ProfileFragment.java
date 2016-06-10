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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Commit;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.models.Player;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Utilities;
import com.jenky.codebuddy.util.TestData;
import com.squareup.okhttp.internal.Util;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {

    private HistoryAdapter historyAdapter;
    private ArrayList<Commit> commits = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();
    private ListView resultListView;
    private RelativeLayout avatar;
    private ImageView head;
    private ImageView shirt;
    private ImageView legs;
    private TextView totalScoreValue;
    private TextView avgScoreValue;
    private TextView achievementsValue;
    private TextView gamesPlayedValue;
    private View rootView;
    private Player player;

    private Callback playerCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
            player = new Player().init(result);

            addStats();
        }

        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
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
        historyAdapter = new HistoryAdapter(getContext(), R.layout.component_history, commits);
        resultListView.setAdapter(historyAdapter);
        resultListView.setOnItemClickListener(this);

        setOnClickListeners();
        //TODO remove test Data
        TestData.addTestCommits(commits);
        getActivity().findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        Request.getRequest((ProgressBar) getActivity().findViewById(R.id.progress_bar)).getProfile(playerCallback);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Commit commit = commits.get(position);
        gotoProjectStats(commit);
    }

    private void gotoProjectStats(Commit commit) {
        //TODO go to StatsActivity
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
        totalScoreValue.setText(Integer.toString(player.getTotalScore()));
        avgScoreValue.setText(Integer.toString(player.getAvgScore()));
        achievementsValue.setText(Integer.toString(player.getAchievements()));
        gamesPlayedValue.setText(Integer.toString(player.getGamesPlayed()));
        setAvater();
    }

    private void setAvater() {
        head = new ImageView(getActivity());
        shirt = new ImageView(getActivity());
        legs = new ImageView(getActivity());

        Picasso.with(getActivity())
                .load(player.getHead().getImage())
                .fit()
                .placeholder(R.drawable.default_head)
                .into(head);
        Picasso.with(getActivity())
                .load(player.getShirt().getImage())
                .fit()
                .placeholder(R.drawable.default_shirt)
                .into(shirt);
        Picasso.with(getActivity())
                .load(player.getLegs().getImage())
                .fit()
                .placeholder(R.drawable.default_legs)
                .into(legs);
        head.setLayoutParams(Utilities.getLayoutParams(getActivity(), 40, 44, 4, 0, 0, 0));
        shirt.setLayoutParams(Utilities.getLayoutParams(getActivity(), 48, 36, 0, 36, 0, 0));
        legs.setLayoutParams(Utilities.getLayoutParams(getActivity(), 34, 24, 11, 67, 0, 0));
        avatar.addView(head);
        avatar.addView(shirt);
        avatar.addView(legs);
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
