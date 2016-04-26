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
 * Created by Jason on 26-Apr-16.
 */
public class ProjectAdapter extends ArrayAdapter {
    public ProjectAdapter(Context context, int resource, ArrayList<Project> items) {
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
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.createdOn = (TextView) convertView.findViewById(R.id.created_on_text);
            viewHolder.members = (TextView) convertView.findViewById(R.id.member_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(project.getName());
        viewHolder.createdOn.setText(project.getCreatedOn().toString());
        viewHolder.members.setText(Integer.toString(project.getMembers()));

        // Populate the data into the template view using the data object
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView createdOn;
        TextView members;
    }
}
