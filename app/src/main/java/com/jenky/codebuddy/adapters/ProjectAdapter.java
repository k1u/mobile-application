package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Jason on 26-Apr-16.
 */
public class ProjectAdapter extends ArrayAdapter {
    public ProjectAdapter(Context context, int resource, List<Project> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Project project = (Project) getItem(position);
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.component_project, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.createdOn = (TextView) convertView.findViewById(R.id.created_on_text);
            viewHolder.members = (TextView) convertView.findViewById(R.id.member_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(project.getName());
        viewHolder.createdOn.setText(Converters.ddMMyyyyToString(project.getCreatedOn()));
        viewHolder.members.setText(String.format(Locale.getDefault(), "%d", project.getMembers()));
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView createdOn;
        TextView members;
    }
}
