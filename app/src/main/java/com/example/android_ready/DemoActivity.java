package com.example.android_ready;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ready.databinding.ActivityDemoBinding;

public class DemoActivity extends AppCompatActivity {

    ActivityDemoBinding binding;

    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

}