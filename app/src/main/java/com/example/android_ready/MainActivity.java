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

import com.example.android_ready.databinding.ActivityMainBinding;
import com.example.android_ready.receiver.MyBroadcastReceiver;
import com.example.android_ready.utils.Utils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyBroadcastReceiver myBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.example.android_ready.MY_NOTIFICATION");
                intent.putExtra("data","My Custom BroadCast Receiver");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onStart() {
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//
//        myBroadcastReceiver = new MyBroadcastReceiver();
//
//        registerReceiver(myBroadcastReceiver,intentFilter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        //unregisterReceiver(myBroadcastReceiver);
        super.onStop();
    }
}