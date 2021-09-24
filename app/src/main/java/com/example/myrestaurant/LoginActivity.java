package com.example.myrestaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{

    //shared preferences
    SharedPreferences sf;
    String file_name = "foodPreference";
    String pref_id = "id";
    String pref_total = "total";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Shared preference
        sf = getSharedPreferences(file_name, MODE_PRIVATE);
        SharedPreferences.Editor edit = sf.edit();

        edit.putString(pref_id, 1 + "");
        edit.putString(pref_total, "0.00");
        edit.commit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}


