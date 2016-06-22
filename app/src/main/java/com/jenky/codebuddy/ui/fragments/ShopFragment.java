package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.adapters.ItemAdapter;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import java.util.ArrayList;

public class ShopFragment extends Fragment {
    private ItemAdapter itemAdapter;
    private ArrayList<Item> items = new ArrayList<>();
    private LinearLayout main;
    private ListView resultListView;
    private String fragmentType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        main = (LinearLayout) view.findViewById(R.id.main);
        resultListView = (ListView) view.findViewById(R.id.result_list_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setItems();
    }

    private void setItems(){
        itemAdapter = new ItemAdapter(getContext(), R.layout.component_item, items);
        resultListView.setAdapter(itemAdapter);
        items.clear();
        fragmentType = getArguments().getString("type");
        ShopActivity activity = (ShopActivity) getActivity();
        for(int i = 0; i < activity.getItems().size(); i++) {
            if(fragmentType.equalsIgnoreCase(activity.getItems().get(i).getType())){
                items.add(activity.getItems().get(i));
            }
        }
        if(items.size() == 0){
            addNoItemsMessage();
        }
        itemAdapter.notifyDataSetChanged();
    }

    private void addNoItemsMessage(){
        TextView noItems = new TextView(getActivity());
        noItems.setText(getString(R.string.no_items_available).replace("{{item_type}}", fragmentType));
        main.removeAllViews();
        main.addView(noItems);
    }
}
