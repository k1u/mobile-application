package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by JTLie on 25-4-2016.
 */
public class ItemAdapter extends ArrayAdapter {
    public ItemAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final Item item = (Item) getItem(position);
        final ViewHolder viewHolder;
        View convertView = view;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.purchase = (Button) convertView.findViewById(R.id.purchase);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(item.getName());
        viewHolder.price.setText(Double.toString(item.getPrice()));
        viewHolder.purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopActivity.purchaseAlert(getContext(), item);
            }
        });
        Picasso.with(getContext())
                .load(item.getImage())
                .placeholder(R.drawable.ic_launcher)
                .into(viewHolder.image);
        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
        Button purchase;
    }
}
