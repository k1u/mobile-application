package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Item;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-5-2016.
 */
public class EquipmentFragment extends DialogFragment implements View.OnClickListener  {

    private ArrayList<Item> itemList = new ArrayList<>();
    private Button helmetPrevious,
            shirtPrevious,
            legsPrevious,
            blockPrevious,
            helmetNext,
            shirtNext,
            legsNext,
            blockNext,
            cancel,
            apply;
    private View rootView;
    private ArrayList<ImageView> helmetImages = new ArrayList<>();
    private ArrayList<ImageView> shirtImages = new ArrayList<>();
    private ArrayList<ImageView> legsImages = new ArrayList<>();
    private ArrayList<ImageView> blockImages = new ArrayList<>();

    private LinearLayout helmetLayout,
            shirtLayout,
            legsLayout,
            blockLayout;

    private int helmetIndex = 0,
            shirtIndex = 0,
            legsIndex = 0,
            blockIndex = 0;


    private Callback getEquipmentCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO fill itemArrayList
        }

        @Override
        public void onFailed(VolleyError error) {

        }
    };

    private Callback setEquipmentCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO create toast
        }

        @Override
        public void onFailed(VolleyError error) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_equipment, container,
                false);
        //TODO remove getItems
        getItems();
        Request.getEquipment(getEquipmentCallback);
        setViews(rootView);
        //TODO move createImages() to getEquipmentCallback success
        createImages(itemList);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return rootView;
    }

    private void getItems() {
        itemList = getArguments().getParcelableArrayList("items");
    }

    private void createImages(ArrayList<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            ImageView imageView = getImageView();
            imageView.setTag(itemList.get(i).getId());
            Picasso.with(getContext())
                    .load(itemList.get(i).getImage())
                    .placeholder(R.drawable.ic_launcher)
                    .into(imageView);
            switch (itemList.get(i).getType()) {
                case "helmet":
                    helmetImages.add(imageView);
                    break;
                case "shirt":
                    shirtImages.add(imageView);
                    break;
                case "legs":
                    legsImages.add(imageView);
                    break;
                case "block":
                    blockImages.add(imageView);
                    break;
                default:
            }
        }
        setCurrentEquipment();
    }

    private ImageView getImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        imageView.setLayoutParams(params);
        return imageView;
    }

    private void setCurrentEquipment() {

        helmetLayout.addView(helmetImages.get(0));
        shirtLayout.addView(shirtImages.get(0));
        legsLayout.addView(legsImages.get(0));
        blockLayout.addView(blockImages.get(0));
    }

    private void setViews(View rootView) {
        helmetPrevious = (Button) rootView.findViewById(R.id.helmet_previous);
        shirtPrevious = (Button) rootView.findViewById(R.id.shirt_previous);
        legsPrevious = (Button) rootView.findViewById(R.id.legs_previous);
        blockPrevious = (Button) rootView.findViewById(R.id.block_previous);
        helmetNext = (Button) rootView.findViewById(R.id.helmet_next);
        shirtNext = (Button) rootView.findViewById(R.id.shirt_next);
        legsNext = (Button) rootView.findViewById(R.id.legs_next);
        blockNext = (Button) rootView.findViewById(R.id.block_next);
        cancel = (Button) rootView.findViewById(R.id.cancel);
        apply = (Button) rootView.findViewById(R.id.apply);

        helmetLayout = (LinearLayout) rootView.findViewById(R.id.helmet_layout);
        shirtLayout = (LinearLayout) rootView.findViewById(R.id.shirt_layout);
        legsLayout = (LinearLayout) rootView.findViewById(R.id.legs_layout);
        blockLayout = (LinearLayout) rootView.findViewById(R.id.block_layout);

        helmetPrevious.setOnClickListener(this);
        shirtPrevious.setOnClickListener(this);
        legsPrevious.setOnClickListener(this);
        blockPrevious.setOnClickListener(this);
        helmetNext.setOnClickListener(this);
        shirtNext.setOnClickListener(this);
        legsNext.setOnClickListener(this);
        blockNext.setOnClickListener(this);
        cancel.setOnClickListener(this);
        apply.setOnClickListener(this);
    }

    private void replaceImage(LinearLayout layout, ImageView image) {
        layout.removeAllViews();
        layout.addView(image);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.helmet_previous:
                helmetIndex--;
                if (helmetIndex < 0) {
                    helmetIndex = helmetImages.size() - 1;
                }
                replaceImage(helmetLayout, helmetImages.get(helmetIndex));
                break;
            case R.id.helmet_next:
                helmetIndex++;
                if (helmetIndex == helmetImages.size()) {
                    helmetIndex = 0;
                }
                replaceImage(helmetLayout,helmetImages.get(helmetIndex));
                break;
            case R.id.shirt_previous:
                shirtIndex++;
                if (shirtIndex == shirtImages.size()) {
                    shirtIndex = 0;
                }
                replaceImage(shirtLayout, shirtImages.get(shirtIndex));
                break;
            case R.id.shirt_next:
                shirtIndex++;
                if (shirtIndex == shirtImages.size()) {
                    shirtIndex = 0;
                }
                replaceImage(shirtLayout, shirtImages.get(shirtIndex));
                break;
            case R.id.legs_previous:
                legsIndex--;
                if (legsIndex < 0) {
                    legsIndex = legsImages.size() - 1;
                }
                replaceImage(legsLayout, legsImages.get(legsIndex));
                break;
            case R.id.legs_next:
                legsIndex++;
                if (legsIndex == legsImages.size()) {
                    legsIndex = 0;
                }
                replaceImage(legsLayout, legsImages.get(legsIndex));
                break;
            case R.id.block_previous:
                blockIndex--;
                if (blockIndex < 0) {
                    blockIndex = blockImages.size() - 1;
                }
                replaceImage(blockLayout, blockImages.get(blockIndex));
                break;
            case R.id.block_next:
                blockIndex++;
                if (blockIndex == blockImages.size()) {
                    blockIndex = 0;
                }
                replaceImage(blockLayout, blockImages.get(blockIndex));
                break;
            case R.id.cancel:
                getDialog().cancel();
                break;
            case R.id.apply:
                Request.setEquipment(setEquipmentCallback,
                        helmetLayout.getChildAt(0).getTag().toString(),
                        shirtLayout.getChildAt(0).getTag().toString(),
                        legsLayout.getChildAt(0).getTag().toString(),
                        blockLayout.getChildAt(0).getTag().toString());

                //TODO remove Toast
                Toast.makeText(getContext(),
                        helmetLayout.getChildAt(0).getTag().toString() + ", " +
                                shirtLayout.getChildAt(0).getTag().toString() + ", " +
                                legsLayout.getChildAt(0).getTag().toString() + ", " +
                                blockLayout.getChildAt(0).getTag().toString(), Toast.LENGTH_SHORT).show();
                getDialog().cancel();
                break;
        }

    }

}
