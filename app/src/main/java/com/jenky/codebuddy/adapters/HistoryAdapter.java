package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Commit;
import com.jenky.codebuddy.util.Utilities;

import java.util.List;
import java.util.Locale;


public class HistoryAdapter extends ArrayAdapter {
    public HistoryAdapter(Context context, int resource, List<Commit> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Commit commit = (Commit) getItem(position);
        final ViewHolder viewHolder;
        View convertView = view;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_history, parent, false);
            viewHolder.project = (TextView) convertView.findViewById(R.id.project_text);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score_text);
            viewHolder.branch = (TextView) convertView.findViewById(R.id.branch_text);
            viewHolder.createdOn = (TextView) convertView.findViewById(R.id.date_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.project.setText(commit.getProjectName());
        viewHolder.score.setText(String.format(Locale.getDefault(), "%d", commit.getScore()));
        viewHolder.branch.setText(commit.getBranch());
        viewHolder.createdOn.setText(Utilities.ddMMyyyyToString(commit.getCreatedOn()));

        // Populate the data into the template view using the data object
        return convertView;
    }

    private class ViewHolder {
        TextView project;
        TextView score;
        TextView branch;
        TextView createdOn;
    }
}
