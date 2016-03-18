package com.example.haresh.dinero;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestCase;


/**
 * Created by ajayrahul on 17/3/16.
 */
public class Details extends Activity{

    TextView grpname,balance;
    Button add,make;
    String s= getIntent().getExtras().getString("fund_name");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_details);
       grpname = (TextView)findViewById(R.id.Fund_name);
       balance = (TextView)findViewById(R.id.total);
        add = (Button)findViewById(R.id.add);
        make = (Button)findViewById(R.id.make);
        grpname.setText("FundGroup: "+s);
        










    }
}
