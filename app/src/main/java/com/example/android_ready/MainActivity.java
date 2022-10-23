package com.example.android_ready;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.MyBroadCastReceiver.MyBroadCastReceiver;
import com.example.android_ready.databinding.ActivityMainBinding;
import com.example.android_ready.utils.Utils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyBroadCastReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");

        myReceiver = new MyBroadCastReceiver();
        registerReceiver(myReceiver, intentFilter);

        super.onStart();
    }

    @Override
    protected void onStop() {

        unregisterReceiver(myReceiver);
        super.onStop();
    }
}