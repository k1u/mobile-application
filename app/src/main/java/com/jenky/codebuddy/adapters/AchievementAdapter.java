package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Achievement;
import com.jenky.codebuddy.util.DateConverter;

import java.util.ArrayList;

/**
 * Created by JTLie on 25-4-2016.
 */
public class AchievementAdapter extends ArrayAdapter {
    public AchievementAdapter(Context context, int resource, ArrayList<Achievement> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        //getResultsFromServer();
        final Achievement achievement = (Achievement) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_achievement, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.completion = (TextView) convertView.findViewById(R.id.completion);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(achievement.getName());
        viewHolder.description.setText(achievement.getDescription());
        viewHolder.completion.setText(Double.toString(achievement.getComplete_percentage()));
        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView description;
        TextView completion;
    }
}
