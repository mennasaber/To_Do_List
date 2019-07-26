package com.example.android.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class taskAdapter extends ArrayAdapter<task> {
    public taskAdapter(Context context, int resource, List<task> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        item currentItem = getItem(position);
        TextView text = listItemView.findViewById(R.id.taskNameId);
        text.setText(currentItem.getIname());
        LinearLayout layout = listItemView.findViewById(R.id.item_layout);
        switch (((task) currentItem).getiPriority()) {
            case 0:
                layout.setBackgroundResource(R.color.yellow_color);
            case 1:
                layout.setBackgroundResource(R.color.orange_color);
            case 2:
                layout.setBackgroundResource(R.color.red_color);
        }
        return listItemView;
    }
}
