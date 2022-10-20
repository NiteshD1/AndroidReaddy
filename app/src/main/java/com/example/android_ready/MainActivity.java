package com.example.android_ready;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ready.databinding.ActivityMainBinding;
import com.example.android_ready.services.MyService;
import com.example.android_ready.utils.Utils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;
    MyService myService;
    ServiceConnection serviceConnection;
    boolean isBindedToService = false;
    ActivityResultLauncher<Intent> activityResultLauncher;

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

                Utils.print("Start Service Clicked");
                startService(intent);
            }
        });

        binding.buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intent != null){
                    stopService(intent);
                }
            }
        });

        binding.buttonBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(serviceConnection == null){
                    serviceConnection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            MyService.ServiceBinder serviceBinder = (MyService.ServiceBinder) iBinder;
                            myService = serviceBinder.getRandomNumberGenerateServiceObject();
                            isBindedToService = true;
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName componentName) {
                            isBindedToService = false;
                        }
                    };
                }
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        binding.buttonUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBindedToService){
                    unbindService(serviceConnection);
                    isBindedToService = false;
                }
            }
        });

        binding.buttonGetRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.print("inside Get Random Number");
                if(myService != null){
                    Utils.print("inside Get Random Number");
                    int randomNumber = myService.getRandomNumber();
                    binding.textView.setText("Random Number : " +String.valueOf(randomNumber));
                }
            }
        });
    }
}