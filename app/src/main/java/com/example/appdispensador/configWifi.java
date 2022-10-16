package com.example.appdispensador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class configWifi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_wifi);
    }

    public void principal(View v){
        Intent i = new Intent(this,principal.class);
        startActivity(i);
    }

    /*public void Home(View v){
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }*/
}