package com.example.appdispensador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class configBt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_bt);
    }

    public void cfgWifi(View v){
        Intent i = new Intent(this,configWifi.class);
        startActivity(i);
    }

}