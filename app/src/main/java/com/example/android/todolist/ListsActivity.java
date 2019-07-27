package com.example.android.todolist;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ListsActivity extends AppCompatActivity {

    EditText listTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        listTitle = (EditText) findViewById(R.id.listTitle);
        listTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO --> if title is null add new title to db , if not update it in db
            }
        });

    }
    private void PopDialog()
    {

        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_task, null);
       final EditText addTask = dialogView.findViewById(R.id.addNewTask);
       Button add = dialogView.findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO --> take from "add task" edit text
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                //TODO --> pop up dialog has edit text and button , add task , put it in list
                PopDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
