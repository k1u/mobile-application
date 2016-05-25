package com.jenky.codebuddy.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-5-2016.
 */
public class EquipmentFragment extends DialogFragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_equipment, container,
                false);
        getItems();
        setViews(rootView);
        createImages(itemList);
        setClickListeners();
        return rootView;
    }

    private void getItems() {
        //TODO get Items from server
        itemList = getArguments().getParcelableArrayList("items");
    }

    private void createImages(ArrayList<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            ImageView imageView = getImageView();
            imageView.setTag(itemList.get(i).getId());
            Picasso.with(getContext())
                    .load(itemList.get(i).getImage())
                    .placeholder(R.drawable.ic_launcher4)
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
        helmetPrevious = (Button) rootView.findViewById(R.id.helmetPrevious);
        shirtPrevious = (Button) rootView.findViewById(R.id.shirtPrevious);
        legsPrevious = (Button) rootView.findViewById(R.id.legsPrevious);
        blockPrevious = (Button) rootView.findViewById(R.id.blockPrevious);
        helmetNext = (Button) rootView.findViewById(R.id.helmetNext);
        shirtNext = (Button) rootView.findViewById(R.id.shirtNext);
        legsNext = (Button) rootView.findViewById(R.id.legsNext);
        blockNext = (Button) rootView.findViewById(R.id.blockNext);
        cancel = (Button) rootView.findViewById(R.id.cancel);
        apply = (Button) rootView.findViewById(R.id.apply);

        helmetLayout = (LinearLayout) rootView.findViewById(R.id.helmetLayout);
        shirtLayout = (LinearLayout) rootView.findViewById(R.id.shirtLayout);
        legsLayout = (LinearLayout) rootView.findViewById(R.id.legsLayout);
        blockLayout = (LinearLayout) rootView.findViewById(R.id.blockLayout);
    }

    private void replaceImage(LinearLayout layout, int index) {
        switch (layout.getId()) {
            case R.id.helmetLayout:
                helmetLayout.removeAllViews();
                helmetLayout.addView(helmetImages.get(index));
                break;
            case R.id.shirtLayout:
                shirtLayout.removeAllViews();
                shirtLayout.addView(shirtImages.get(index));
                break;
            case R.id.legsLayout:
                legsLayout.removeAllViews();
                legsLayout.addView(legsImages.get(index));
                break;
            case R.id.blockLayout:
                blockLayout.removeAllViews();
                blockLayout.addView(blockImages.get(index));
                break;
        }
    }


    private void setClickListeners() {
        helmetPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helmetIndex--;
                if (helmetIndex < 0) {
                    helmetIndex = helmetImages.size() - 1;
                }
                replaceImage(helmetLayout, helmetIndex);
            }
        });
        helmetNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helmetIndex++;
                if (helmetIndex == helmetImages.size()) {
                    helmetIndex = 0;
                }
                replaceImage(helmetLayout, helmetIndex);
            }
        });
        shirtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtIndex--;
                if (shirtIndex < 0) {
                    shirtIndex = shirtImages.size() - 1;
                }
                replaceImage(shirtLayout, shirtIndex);
            }
        });
        shirtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtIndex++;
                if (shirtIndex == shirtImages.size()) {
                    shirtIndex = 0;
                }
                replaceImage(shirtLayout, shirtIndex);
            }
        });
        legsPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                legsIndex--;
                if (legsIndex < 0) {
                    legsIndex = legsImages.size() - 1;
                }
                replaceImage(legsLayout, legsIndex);
            }
        });
        legsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                legsIndex++;
                if (legsIndex == legsImages.size()) {
                    legsIndex = 0;
                }
                replaceImage(legsLayout, legsIndex);
            }
        });
        blockPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockIndex--;
                if (blockIndex < 0) {
                    blockIndex = blockImages.size() - 1;
                }
                replaceImage(blockLayout, blockIndex);
            }
        });
        blockNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockIndex++;
                if (blockIndex == blockImages.size()) {
                    blockIndex = 0;
                }
                replaceImage(blockLayout, blockIndex);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO send Ids to server
                Toast.makeText(getContext(),
                        helmetLayout.getChildAt(0).getTag().toString() + ", " +
                                shirtLayout.getChildAt(0).getTag().toString() + ", " +
                                legsLayout.getChildAt(0).getTag().toString() + ", " +
                                blockLayout.getChildAt(0).getTag().toString(), Toast.LENGTH_SHORT).show();
                getDialog().cancel();
            }
        });
    }


}
