package com.example.android.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_handler extends SQLiteOpenHelper {
    private static final int _Database_version = 1;
    private static final String _Database_name = "TO_DO_LIST";
    private static final String TABLE_ITEM = "Items";
    private static final String TABlE_TASK = "Task";
    private static final String _Maintask_id = "_maintask_id";
    private static final String _Maintask_name = "_maintask_name";
    private static final String _Maintask_checked = "_maintask_checked";
    private static final String _Task_id = "_task_id";
    private static final String _Name = "_name";
    private static final String _Checked = "_checked";
    private static final String _Priority = "_priority";
    private static final String _Time = "_time";


    private static final String query = "CREATE TABLE " + TABLE_ITEM + "(" + _Maintask_id
            + " INTEGER PRIMARY KEY AUTOINCREMENT ," + _Maintask_name
            + " TEXT ," + _Maintask_checked + " BOOLEAN  " + ")";


    private static final String query2 = "CREATE TABLE "
            + TABlE_TASK + "(" + _Task_id
            + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + _Name + "TEXT ," + _Checked + "BOOLEAN ,"
            + _Priority + "INTEGER ," + _Time + "TEXT" + _Maintask_id + "INTEGER " + ")";
    public DB_handler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, _Database_name, factory, _Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(query);
        db.execSQL(query2);

//        private static final String CREATE_TALK_TABLE = "CREATE TABLE " + TABLE_NAME_1 + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COLUMN_DATE + " TEXT," +
//                COLUMN_USERNAME + " INTEGER," +
//                COLUMN_MESSAGE + " TEXT)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_Item(item Item) {
        ContentValues values = new ContentValues();
        values.put(_Maintask_name, Item.getIname());
        values.put(_Maintask_checked, Item.isiChecked());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEM, null, values);
        db.close();
    }

    public void add_task(task Task, int id_maintask) {
        ContentValues values = new ContentValues();
        values.put(_Name, Task.getTname());
        values.put(_Checked, Task.isTchecked());
        values.put(_Priority, Task.gettPriority());
        values.put(_Time, Task.gettTime());
        values.put(_Maintask_id, id_maintask);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEM, null, values);
        db.close();

}
    public void update_item(item Item) {
        ContentValues values = new ContentValues();
        values.put(_Maintask_checked, Item.isiChecked());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_ITEM, values, "_Maintask_id=" + Item.getiID(), null);
    }

    public void update_task(task Task) {
        ContentValues values = new ContentValues();
        values.put(_Checked, Task.isTchecked());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABlE_TASK, values, "_task_id=" + Task.gettID(), null);
    }

    public ArrayList<item> read_item() {
        item Items;
        ArrayList<item> items = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * From " + TABLE_ITEM;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            Items = new item(Integer.parseInt(cursor.getString(cursor.getColumnIndex(_Maintask_id))), cursor.getString(cursor.getColumnIndex(_Maintask_name)),
                    Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(_Maintask_checked))));
            items.add(Items);
        }
        return items;
    }

    public ArrayList<task> read_task(int id_item) {
        task Tasks;
        ArrayList<task> tasks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * From " + TABlE_TASK + "WHERE" + _Maintask_id + "=" + id_item;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            Tasks = new task(cursor.getString(cursor.getColumnIndex(_Name)),
                    Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(_Checked))), Integer.parseInt(cursor.getString(cursor.getColumnIndex(_Priority)))
                    , cursor.getString(cursor.getColumnIndex(_Time)));
            tasks.add(Tasks);

        }
        return tasks;
    }

    public void delete_item(int id_item) {
        String query = "DELETE FROM " + TABLE_ITEM + " WHERE " + _Maintask_id + " = " + id_item;
        String query2 = "DELETE FROM " + TABlE_TASK + " WHERE " + _Maintask_id + " = " + id_item;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.execSQL(query2);
        db.close();

    }

    public void delete_task(int id_task) {
        String query = "DELETE FROM " + TABlE_TASK + " WHERE " + _Maintask_id + " = " + id_task;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();

    }
}
