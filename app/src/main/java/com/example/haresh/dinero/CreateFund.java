package com.example.haresh.dinero;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ajayrahul on 17/3/16.
 */
public class CreateFund extends Activity {
    static int user_num = 1;

    UserDatabase usd;
    FundDatabase fdb;
    FundNamedb fndb;
    MemberFundDB mfdb;

    Button create;
    EditText fname,amount;
    String fundname, amnt;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fundform);
        usd= new UserDatabase(CreateFund.this);
        fdb= new FundDatabase(CreateFund.this);
        fndb= new FundNamedb(CreateFund.this);
        mfdb= new MemberFundDB(CreateFund.this);

        create = (Button) findViewById(R.id.btn_create);
        fname = (EditText) findViewById(R.id.fundname);
        amount = (EditText) findViewById(R.id.amount);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fundname = fname.getText().toString();
                amnt = amount.getText().toString();
                userdata ud = usd.getuser(user_num);




            }
        });

    }
}
