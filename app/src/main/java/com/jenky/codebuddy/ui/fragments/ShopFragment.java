package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ItemAdapter;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import com.jenky.codebuddy.util.TestData;

import java.util.ArrayList;

/**
 * Created by Jason on 12-May-16.
 */
public class ShopFragment extends Fragment  {
    private ItemAdapter itemAdapter;
    private ArrayList<Item> items = new ArrayList<>();
    private ListView resultListView;
    private String type;

    public ShopFragment(String type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        resultListView = (ListView) view.findViewById(R.id.result_list_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemAdapter = new ItemAdapter(getContext(), R.layout.component_item, items);
        resultListView.setAdapter(itemAdapter);

        items.clear();
        //TODO remove Test Data
        switch(type) {
            case "helmet":
                TestData.addTestHelmets(items);
                break;
            case "shirt":
                TestData.addTestShirts(items);
                break;
            case "legs":
                TestData.addTestLegs(items);
                break;
            case "block":
                TestData.addTestBlocks(items);
                break;
        }
        ShopActivity activity = (ShopActivity) getActivity();
        items = activity.getItems();
        itemAdapter.notifyDataSetChanged();
    }

}
