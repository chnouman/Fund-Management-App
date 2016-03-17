package com.example.haresh.dinero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class MemberFundDB extends SQLiteOpenHelper{

    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "MemberFundDatabase",
            TABLE_NAME ="MEMBERFUNDINFO",
            KEY_ID = "id",
            KEY_NAME = "name",
            KEY_FUNDNAME ="fund"

                    ;


    public MemberFundDB(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_FUNDNAME + " TEXT,"  + ")");
        
    }

    public memberfunddata getuser(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_FUNDNAME}, KEY_NAME + "=?", new String[]{name}, null, null , null);
        if (cursor != null)
            cursor.moveToFirst();
        memberfunddata mfd = new memberfunddata(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return mfd;
    }


    public void addinfo (memberfunddata mfd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,mfd.get_id());
        values.put(KEY_NAME, mfd.get_name()); // Contact name
        values.put(KEY_FUNDNAME, mfd.get_fundname()); //



        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        //sortTable();
    }




}
