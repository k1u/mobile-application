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
import java.util.ArrayList;

public class ShopFragment extends Fragment {
    private ItemAdapter itemAdapter;
    private ArrayList<Item> items = new ArrayList<>();
    private ListView resultListView;
    private String fragmentType;

    public ShopFragment( ) {

    }

    public ShopFragment(String type) {
        this.fragmentType = type;
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
        setItems();

    }

    private void setItems(){
        itemAdapter = new ItemAdapter(getContext(), R.layout.component_item, items);
        resultListView.setAdapter(itemAdapter);
        items.clear();
        ShopActivity activity = (ShopActivity) getActivity();
        for(int i = 0; i < activity.getItems().size(); i++) {
            if(fragmentType.equalsIgnoreCase(activity.getItems().get(i).getType())){
                items.add(activity.getItems().get(i));
            }
        }
        itemAdapter.notifyDataSetChanged();
    }
}
