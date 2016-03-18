package com.example.haresh.dinero;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ajayrahul on 18/3/16.
 */
public class ListUser extends ListActivity{
    SQLiteDatabase db;
    String array[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=openOrCreateDatabase("UserDatabase", Context.MODE_PRIVATE, null);

        Cursor crs =null;
        crs = db.rawQuery("SELECT * FROM USERINFO", null);
        array= new String[crs.getCount()];
        int i = 0;
        while(crs.moveToNext()){
            String uname = crs.getString(crs.getColumnIndex("name"));
            array[i] = uname;

            i++;
        }

        setListAdapter(new ArrayAdapter<String>(ListUser.this, android.R.layout.simple_list_item_1, array));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub

        String abcd= array[position];
        super.onListItemClick(l, v, position, id);
        Intent myintent= new Intent(ListUser.this, Details.class);
        Intent d = new Intent(ListUser.this,Details.class);
        d.putExtra("user",abcd);
        d.putExtra("type", "li");
        startActivity(d);
        finish();


    }





}
