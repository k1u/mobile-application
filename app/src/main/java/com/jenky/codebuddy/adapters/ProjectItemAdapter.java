package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.IntentFactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by JTLie on 25-4-2016.
 */
public class ProjectItemAdapter extends ArrayAdapter {
    public ProjectItemAdapter(Context context, int resource, ArrayList<Project> items) {
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
            convertView = inflater.inflate(R.layout.component_project, null);
            viewHolder.project = (TextView) convertView.findViewById(R.id.project_text);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score_text);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_text);
            viewHolder.rank = (TextView) convertView.findViewById(R.id.rank_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.project.setText(project.getName());
        viewHolder.score.setText(project.getScore()+ "");
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
