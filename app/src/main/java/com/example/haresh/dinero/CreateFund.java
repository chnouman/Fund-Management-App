package com.example.haresh.dinero;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ajayrahul on 17/3/16.
 */
public class CreateFund extends Activity {

    UserDatabase usd;
    FundDatabase fdb;
    FundNamedb fndb;
    MemberFundDB mfdb;

    Button create;
    EditText fname,amount,dt;
    String fundname, amnt,details;
    String username;
    int trans;

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
        dt= (EditText)findViewById(R.id.details);
        amount = (EditText) findViewById(R.id.amount);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fundname = fname.getText().toString();
                amnt = amount.getText().toString();
                details = dt.getText().toString();

                trans = Integer.parseInt(amnt);
                userdata ud = usd.getuser(Helpers.user_email);
                funddata fd = new funddata(Helpers.user_name,fundname,trans,details);
                fundlistdata fld = new fundlistdata(fundname);
                memberfunddata mfd = new memberfunddata(Helpers.user_name,fundname);
                fndb.addfundname(fld);

                fdb.addfund(fd);
                mfdb.addinfo(mfd);

                Intent i =new Intent(CreateFund.this,Details.class);
                i.putExtra("fund_name",fundname);
                i.putExtra("type","c");
                startActivity(i);







            }
        });

    }
}
