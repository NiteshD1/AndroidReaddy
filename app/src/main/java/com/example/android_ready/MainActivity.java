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
    private ServiceConnection serviceConnection;
    private boolean isBoundToService = false;
    MyService myService;

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
                    stopService(intent);
            }
        });

        binding.buttonBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(serviceConnection == null){
                    serviceConnection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            isBoundToService = true;
                            MyService.ServiceBinder serviceBinder = (MyService.ServiceBinder) iBinder;
                            myService = serviceBinder.getMyServiceInstance();
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName componentName) {
                            isBoundToService = false;

                        }
                    };
                }
                bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
            }
        });

        binding.buttonUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoundToService){
                    unbindService(serviceConnection);
                    isBoundToService = false;
                }
            }
        });

        binding.buttonGetRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myService != null){
                    int currentRandomNumber = myService.getCurrentRandomNumber();
                    binding.textView.setText(String.valueOf(currentRandomNumber));
                }

            }
        });

    }
}