package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-5-2016.
 */
public class EquipmentFragment extends DialogFragment {

    private ArrayList<Item> itemList = new ArrayList<Item>();


    private ArrayList<ImageView> helmetImages = new ArrayList<ImageView>();
    private ArrayList<ImageView> shirtsImages = new ArrayList<ImageView>();
    private ArrayList<ImageView> legsImages = new ArrayList<ImageView>();
    private ArrayList<ImageView> blocksImages = new ArrayList<ImageView>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_equipment, container,
                false);
        getItems();
        createImages(itemList);

        return rootView;
    }

    private void getItems() {
        //TODO get Items from server
        itemList = getArguments().getParcelableArrayList("items");
    }

    private void createImages(ArrayList<Item> itemList) {
        for(int i = 0; i<itemList.size();i++){
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext())
                    .load(itemList.get(i).getImage())
                    .placeholder(R.drawable.ic_launcher4)
                    .into(imageView);
            switch(itemList.get(i).getType()){
                case "helmet":
                    helmetImages.add(imageView);
                    break;
                case "shirt":
                    shirtsImages.add(imageView);
                    break;
                case "legs":
                    legsImages.add(imageView);
                    break;
                case "block":
                    blocksImages.add(imageView);
                    break;
            }
        }

    }
}
