package com.example.android.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_helper extends SQLiteOpenHelper {
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

    public DB_helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, _Database_name, factory, _Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ITEM + "(" + _Maintask_id
                + " INTEGER PRIMARY KEY AUTOINCREMENT ," + _Maintask_name
                + " TEXT ," + _Maintask_checked + " BOOLIEAN" + ")";

        String query2 =  "CREATE TABLE "
                + TABlE_TASK + "(" + _Task_id
                + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + _Name + "TEXT ," + _Checked + "BOOLEAN ,"
                + _Priority + "INTEGER ," + _Time + "TEXT" +_Maintask_id +"INTEGER "+")";
        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_Item(item Item) {
        ContentValues values = new ContentValues();
        values.put(_Maintask_name ,Item.getIname());
        values.put(_Maintask_checked ,Item.isiChecked());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_ITEM ,null,values);
        db.close();
    }
    public void add_task(task Task) {
        ContentValues values = new ContentValues();
        values.put( _Name,Task.getIname());
        values.put(_Checked ,Task.isiChecked());
        values.put(_Priority,Task.getiPriority());
        values.put(_Time ,Task.getiTime());
        values.put(_Checked ,Task.isiChecked());
        values.put( _Maintask_id,Task.getiID());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_ITEM ,null,values);
        db.close();
    }
    public void appdate_item(item Item){
       ContentValues values=new ContentValues();
       values.put(_Maintask_checked,Item.isiChecked());
        SQLiteDatabase db=getWritableDatabase();
        db.update(TABLE_ITEM,values,"_Maintask_id="+Item.getiID(),null);
    }
    public void appdate_task(task Task){
        ContentValues values=new ContentValues();
        values.put(_Checked,Task.isiChecked());
        SQLiteDatabase db=getWritableDatabase();
        db.update(TABlE_TASK,values,"_task_id="+Task.getiID(),null);
    }
}
