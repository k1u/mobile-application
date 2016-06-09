package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by JTLie on 25-4-2016.
 */
public class HistoryAdapter extends ArrayAdapter {
    public HistoryAdapter(Context context, int resource, List<Project> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Project project = (Project) getItem(position);
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_history, parent, false);
            viewHolder.project = (TextView) convertView.findViewById(R.id.project_text);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score_text);
            viewHolder.rank = (TextView) convertView.findViewById(R.id.rank_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.project.setText(project.getName());
        viewHolder.score.setText(String.format(Locale.getDefault(), "%d", project.getScore()));
        viewHolder.rank.setText(String.format(Locale.getDefault(), "%d", project.getRank()));

        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView project;
        TextView score;

        TextView rank;
    }
}
