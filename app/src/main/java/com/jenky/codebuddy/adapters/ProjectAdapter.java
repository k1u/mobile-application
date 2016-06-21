package com.jenky.codebuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.models.Project;
import com.jenky.codebuddy.util.Utilities;
import java.util.List;
import java.util.Locale;


public class ProjectAdapter extends ArrayAdapter {
    public ProjectAdapter(Context context, int resource, List<Project> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final Project project = (Project) getItem(position);
        final ViewHolder viewHolder;
        View convertView = view;
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
        viewHolder.createdOn.setText(Utilities.ddMMyyyyToString(project.getCreatedOn()));
        viewHolder.members.setText(String.format(Locale.getDefault(), "%d", project.getMembers()));
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView createdOn;
        TextView members;
    }
}
