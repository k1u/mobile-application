package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Item;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-5-2016.
 */
public class EquipmentFragment extends DialogFragment {

    private ArrayList<Item> heads = new ArrayList<Item>();
    private ArrayList<Item> shirts = new ArrayList<Item>();
    private ArrayList<Item> legs = new ArrayList<Item>();
    private ArrayList<Item> blocks = new ArrayList<Item>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_equipment, container,
                false);
        getItems();
        return rootView;
    }

    private void getItems() {
        heads = getArguments().getParcelableArrayList("heads");
        shirts = getArguments().getParcelableArrayList("shirts");
        legs = getArguments().getParcelableArrayList("legs");
        blocks = getArguments().getParcelableArrayList("blocks");
    }
}
