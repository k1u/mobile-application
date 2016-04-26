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

/**
 * Created by JTLie on 25-4-2016.
 */
public class HistoryAdapter extends ArrayAdapter {
    public HistoryAdapter(Context context, int resource, ArrayList<Project> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        //getResultsFromServer();
        final Project project = (Project) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_history, null);
            viewHolder.project = (TextView) convertView.findViewById(R.id.project_text);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score_text);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_text);
            viewHolder.rank = (TextView) convertView.findViewById(R.id.rank_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.project.setText(project.getName());
        viewHolder.score.setText(Integer.toString(project.getScore()));
        viewHolder.status.setText(project.getStatus());
        viewHolder.rank.setText(project.getRank());




        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView project;
        TextView score;
        TextView status;
        TextView rank;

    }
}
