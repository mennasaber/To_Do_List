package com.example.android.todolist;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {
    DB_handler db ;
    ArrayList<item> items = new ArrayList<>();
    trackAdapter ad;
    ListView lv;
    static int id_track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB_handler(this, null, null, 1);
        items = db.read_item();
        lv=(ListView)findViewById(R.id.TracksID);
        ad = new trackAdapter(MainActivity.this, 0, items);
        lv.setAdapter(ad);
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_track = items.get(i).getiID();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
                PopDialog();
                return true;
            default:
                return false;
        }
    }

    private void PopDialog() {
        final AlertDialog dialogBuilder = new AlertDialog.Builder(MainActivity.this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_track, null);
        final EditText addTrack = dialogView.findViewById(R.id.addNewTrack);
        Button add = dialogView.findViewById(R.id.buttonAddTrack);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item _item = new item(String.valueOf(addTrack.getText()), false);
                db.add_Item(_item);
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }
}
