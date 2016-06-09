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

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.util.AppController;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-5-2016.
 */
public class EquipmentFragment extends DialogFragment implements View.OnClickListener {

    private ArrayList<Item> itemList = new ArrayList<>();
    private Button helmetPrevious;
    private Button shirtPrevious;
    private Button legsPrevious;
    private Button blockPrevious;
    private Button helmetNext;
    private Button shirtNext;
    private Button legsNext;
    private Button blockNext;
    private Button cancel;
    private Button apply;
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

        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    private Callback setEquipmentCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO notify user
        }

        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_equipment, container,
                false);
        //TODO remove getItems
        getItems();
        Request.getRequest(null).getEquipment(getEquipmentCallback);
        setViews(rootView);
        setOnclickListeners();
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
    }

    private void setOnclickListeners(){
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
        switch (id) {
            case R.id.helmet_previous:
                helmetIndex = ((helmetIndex-1) < 0) ? helmetImages.size() - 1: helmetIndex - 1;
                replaceImage(helmetLayout, helmetImages.get(helmetIndex));
                break;
            case R.id.helmet_next:
                helmetIndex = ((helmetIndex+1) == helmetImages.size()) ? 0 : helmetIndex + 1;
                replaceImage(helmetLayout, helmetImages.get(helmetIndex));
                break;
            case R.id.shirt_previous:
                shirtIndex = ((shirtIndex-1) < 0) ? shirtImages.size() - 1: shirtIndex - 1;
                replaceImage(shirtLayout, shirtImages.get(shirtIndex));
                break;
            case R.id.shirt_next:
                shirtIndex = ((shirtIndex+1) == shirtImages.size()) ? 0: shirtIndex + 1;
                replaceImage(shirtLayout, shirtImages.get(shirtIndex));
                break;
            case R.id.legs_previous:
                legsIndex = ((legsIndex-1) < 0) ? legsImages.size() - 1: legsIndex - 1;
                replaceImage(legsLayout, legsImages.get(legsIndex));
                break;
            case R.id.legs_next:
                legsIndex = ((legsIndex+1) == legsImages.size()) ?  0: legsIndex + 1;
                replaceImage(legsLayout, legsImages.get(legsIndex));
                break;
            case R.id.block_previous:
                blockIndex = ((blockIndex-1) < 0) ? blockImages.size() - 1: blockIndex - 1;
                replaceImage(blockLayout, blockImages.get(blockIndex));
                break;
            case R.id.block_next:
                blockIndex = ((blockIndex+1) == blockImages.size()) ?  0: blockIndex + 1;
                replaceImage(blockLayout, blockImages.get(blockIndex));
                break;
            case R.id.cancel:
                getDialog().cancel();
                break;
            case R.id.apply:
                Request.getRequest(null).setEquipment(setEquipmentCallback,
                        helmetLayout.getChildAt(0).getTag().toString(),
                        shirtLayout.getChildAt(0).getTag().toString(),
                        legsLayout.getChildAt(0).getTag().toString(),
                        blockLayout.getChildAt(0).getTag().toString());
                getDialog().cancel();
                break;
        }

    }

}
