package com.example.haresh.dinero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestCase;


/**
 * Created by ajayrahul on 17/3/16.
 */
public class Details extends Activity{

    TextView grpname,balance;
    Button add,make;
    FundDatabase fd;
    int total;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_details);
        fd =new FundDatabase(Details.this);
       grpname = (TextView)findViewById(R.id.Fund_name);
       balance = (TextView)findViewById(R.id.total);
        add = (Button)findViewById(R.id.add);
        make = (Button)findViewById(R.id.make);
        String s= getIntent().getExtras().getString("fund_name");

        grpname.setText("FundGroup: "+s);
        total = fd.getsum(s);
        s= Integer.toString(total);
        balance.setText("Current Balance : "+s);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Details.this,Transaction.class);
                startActivity(i);


            }
        });










    }
}
