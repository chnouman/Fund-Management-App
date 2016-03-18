package com.example.haresh.dinero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class FundNamedb extends SQLiteOpenHelper{

    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "FundListDatabase",
            TABLE_NAME ="FUNDLIST",
            KEY_ID = "id",
            KEY_FUNDNAME ="fund"

                    ;


    public FundNamedb(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTO INCREMENT,"  + KEY_FUNDNAME + " TEXT," + ")");
        
    }


    public fundlistdata getuser(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,  KEY_FUNDNAME}, KEY_FUNDNAME + "=?", new String[]{name}, null, null , null, null);
        if (cursor != null)
            cursor.moveToFirst();
        fundlistdata fld = new fundlistdata( cursor.getString(1));
        return fld;
    }


    public void addfundname(fundlistdata fld) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(KEY_ID,fld.get_id());
        values.put(KEY_FUNDNAME, fld.get_fundname());


        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        //sortTable();
    }




}
