package com.example.android_ready;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ready.databinding.ActivityMainBinding;
import com.example.android_ready.service.MyService;
import com.example.android_ready.utils.Utils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = new Intent(MainActivity.this, MyService.class);
        setupButtons();

    }

    private void setupButtons() {

        binding.buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.print("start Service clicked");
                startService(intent);
            }
        });

        binding.buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }

}