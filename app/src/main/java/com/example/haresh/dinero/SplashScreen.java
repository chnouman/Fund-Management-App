package com.example.haresh.dinero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;

public class SplashScreen extends Activity {

    public static int SPLASH_TIME_OUT = 2000;

    static SharedPreferences sharedPreferences;
    UserDatabase dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        dbh = new UserDatabase(this);
        if(dbh.getUserCount() == 0){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLogin",false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Starts app main activity
                if(sharedPreferences.getBoolean("isLogin",true)) {
                    Intent intent = new Intent(SplashScreen.this, MainScreen.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
