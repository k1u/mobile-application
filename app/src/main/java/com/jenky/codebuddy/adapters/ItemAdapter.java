package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.models.Item;
import com.jenky.codebuddy.ui.activities.ShopActivity;
import com.jenky.codebuddy.util.AppController;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


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
            viewHolder.progressBar = (ProgressBar) convertView.findViewById(R.id.progress_bar);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(item.getName());
        viewHolder.price.setText(getContext().getString(R.string.price) + " " + Integer.toString(item.getPrice()));
        if(ShopActivity.purchased.contains(item.getId())){
            disableButton(viewHolder.purchase);
        }else {
            viewHolder.purchase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    purchaseAlert(getContext(), item, viewHolder.purchase, viewHolder.progressBar);
                }
            });
        }
        Picasso.with(getContext())
                .load(item.getImage())
                .placeholder(R.drawable.ic_launcher)
                .into(viewHolder.image);
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
        Button purchase;
        ProgressBar progressBar;
    }

    private void purchaseAlert(final Context context, final Item item, final Button button, final ProgressBar progressBar) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(context.getString(R.string.purchase_alert));
        alertDialog.setMessage(item.getName());
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, int which) {
                        dialog.dismiss();
                        progressBar.setVisibility(View.VISIBLE);
                        Request.getPurchase(new Callback() {
                            @Override
                            public void onSuccess(JSONObject result) throws JSONException {
                                disableButton(button);
                                ShopActivity.purchased.add(item.getId());
                                int oldCurrency = Integer.parseInt(ShopActivity.jenkyCoins.getText().toString());
                                int newCurrency = oldCurrency - item.getPrice();
                                ShopActivity.jenkyCoins.setText(Integer.toString(newCurrency));
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(AppController.getInstance(), "Purchase Successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed(JSONObject result) throws JSONException {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
                            }
                        }, item.getId());
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void disableButton(Button button) {
        button.setText(R.string.purchased);
        button.setBackground(ContextCompat.getDrawable(AppController.getInstance(), R.drawable.disabled_button));
        button.setClickable(false);
    }
}
