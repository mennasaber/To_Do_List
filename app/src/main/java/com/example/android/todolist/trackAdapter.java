package com.example.android.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class trackAdapter extends ArrayAdapter<item> {
    public trackAdapter(Context context, int resource, List<item> objects) {
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

        return listItemView;
    }
}
