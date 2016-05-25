package com.jenky.codebuddy.customViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jenky.codebuddy.R;

/**
 * Created by JTLie on 25-5-2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView imageview;




    public RecyclerViewHolder(View view) {
        super(view);
        // Find all views ids

        this.title = (TextView) view
                .findViewById(R.id.title);
        this.imageview = (ImageView) view
                .findViewById(R.id.image);


    }


}
