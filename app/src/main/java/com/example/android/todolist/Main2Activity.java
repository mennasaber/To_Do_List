package com.example.android.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    DB_handler db;
    EditText listTitle;
    ArrayList<task> items = new ArrayList<>();
    ArrayList<task> items1 = new ArrayList<>();
    ArrayList<task> items2 = new ArrayList<>();
    taskAdapter ad1;
    taskAdapter ad2;
    ListView lv1;
    ListView lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        listTitle = (EditText) findViewById(R.id.listTitle);
        listTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "dsg", Toast.LENGTH_SHORT).show();
                db = new DB_handler(Main2Activity.this, null, null, 1);

                getData();

                lv1.setAdapter(ad1);
                lv2.setAdapter(ad2);

                lv1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        db.update_task(items1.get(i));
                        getData();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                lv2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        db.update_task(items2.get(i));
                        getData();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                //TODO --> if title is null add new title to db , if not update it in db
            }
        });

    }

    private void getData() {
        items = db.read_task(MainActivity.id_track);

        items1 = getItems(items, false);
        items2 = getItems(items, true);

        lv1 = (ListView) findViewById(R.id.listID);
        lv2 = (ListView) findViewById(R.id.checkedList);

        ad1 = new taskAdapter(Main2Activity.this, 0, items1);
        ad2 = new taskAdapter(Main2Activity.this, 0, items2);
    }

    private ArrayList<task> getItems(ArrayList<task> items, boolean b) {
        ArrayList<task> list = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isTchecked() == b)
                list.add(items.get(i));
        }
        return list;
    }

    private void PopDialog() {
        final AlertDialog dialogBuilder = new AlertDialog.Builder(Main2Activity.this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_task, null);
        final EditText addTask = dialogView.findViewById(R.id.addNewTask);
        Button add = dialogView.findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task _task = new task(String.valueOf(addTask.getText()), false,0);
                db.add_task(_task,MainActivity.id_track);
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
        switch (item.getItemId()) {
            case R.id.add:
                //TODO --> pop up dialog has edit text and button , add task , put it in list
                PopDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
