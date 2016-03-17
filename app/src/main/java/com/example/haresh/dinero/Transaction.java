package com.example.haresh.dinero;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by ajayrahul on 17/3/16.
 */
public class Transaction extends Activity {

    EditText amount ,details;
    Button b;
    RadioButton d,w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fundtransaction);
        amount= (EditText) findViewById(R.id.transaction);
        details= (EditText) findViewById(R.id.details);
        b= (Button) findViewById(R.id.checkout);
        d= (RadioButton) findViewById(R.id.deposit);
        w= (RadioButton) findViewById(R.id.withdraw);



    }
}
