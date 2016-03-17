package com.example.haresh.dinero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ajayrahul on 16/3/16.
 */
public class UserDatabase extends SQLiteOpenHelper{

    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "UserDatabase",
            TABLE_NAME ="USERINFO",
            KEY_ID = "id",
            KEY_NAME = "name",
            KEY_EMAIL = "email",
            KEY_PASSWORD="password",
            TABLE_FUND="FUNDDB",
            KEY_ID2="id2",
            KEY_FUNDNAME ="fund",
            KEY_TRANS="money"
                    ;


    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASSWORD + " TEXT" + ")");

    }

    public Boolean checkUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_EMAIL, KEY_PASSWORD}, KEY_EMAIL + " = ?",
                new String[]{String.valueOf(email)}, null, null, null, null);

        return cursor.getCount() > 0;
    }

    public userdata getuser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_EMAIL, KEY_PASSWORD}, KEY_EMAIL + "=?", new String[]{email}, null, null , null, null);
        if (cursor != null)
            cursor.moveToFirst();

        userdata ud = new userdata(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return ud;
    }


    public void signup (userdata ud) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,ud.get_id());
        values.put(KEY_NAME, ud.get_name()); // Contact name
        values.put(KEY_EMAIL, ud.get_email()); //
        values.put(KEY_PASSWORD, ud.get_password()); //

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        //sortTable();
    }




}
