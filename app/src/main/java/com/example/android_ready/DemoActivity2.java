package com.example.android_ready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_ready.databinding.ActivityDemo2Binding;
import com.example.android_ready.databinding.ActivityMainBinding;

public class DemoActivity2 extends BaseAppActivity {

    ActivityDemo2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDemo2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();

    }

    private void setupButtons() {
        binding.buttonStartDemoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity2.this,DemoActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonStartMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


        binding.buttonStartDemoActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity2.this,DemoActivity2.class);
                startActivity(intent);
            }
        });
    }
}