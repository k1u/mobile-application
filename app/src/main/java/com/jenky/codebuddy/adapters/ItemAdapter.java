package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-4-2016.
 */
public class ItemAdapter extends ArrayAdapter {
    public ItemAdapter(Context context, int resource, ArrayList<Item> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        //getResultsFromServer();
        final Item item = (Item) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_item, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(item.getName());
        viewHolder.price.setText(Double.toString(item.getPrice()));
        Picasso.with(getContext())
                .load(item.getImage())
                .placeholder(R.drawable.ic_launcher4)
                .into(viewHolder.image);

        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
    }
}
