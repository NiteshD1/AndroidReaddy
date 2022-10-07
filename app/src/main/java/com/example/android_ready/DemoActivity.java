package com.example.android_ready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_ready.Utils.Utils;
import com.example.android_ready.databinding.ActivityDemoBinding;
import com.example.android_ready.databinding.ActivityMainBinding;

public class DemoActivity extends BaseAppActivity {

    ActivityDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();

    }

    private void setupButtons() {
        binding.buttonStartMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonStartDemoActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity.this,DemoActivity2.class);
                startActivity(intent);
            }
        });
    }
}