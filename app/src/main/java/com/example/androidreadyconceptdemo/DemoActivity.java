package com.example.androidreadyconceptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.androidreadyconceptdemo.Utils.Utils;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Intent intent = getIntent();

        if(intent != null){
            String message = intent.getExtras().getString(Intent.EXTRA_TEXT);
            Utils.showToast(message);
        }
    }
}