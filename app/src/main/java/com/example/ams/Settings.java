package com.example.ams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Settings extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        LinearLayout LogoutBtn = findViewById(R.id.sopt4);
        LinearLayout settingLinear = findViewById(R.id.sopt3);
        LinearLayout timeTable = findViewById(R.id.sopt2);
        settingLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoUpdate = new Intent(getApplicationContext(), Update.class);
                startActivity(gotoUpdate);
            }
        });
        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTimeTable = new Intent(getApplicationContext() , TimeTable.class);
                startActivity(gotoTimeTable);
            }
        });
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoLoginpg = new Intent(getApplicationContext() , Login.class);
                homepage.user = null ;
                homepage.auth = null ;
                startActivity(gotoLoginpg);
                finishAffinity();
            }
        });


    }
}