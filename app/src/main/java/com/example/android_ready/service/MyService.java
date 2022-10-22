package com.example.android_ready.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.android_ready.utils.Utils;

import java.util.Random;

public class MyService extends Service {

    boolean shouldGenerateRandomNumber = false;

    @Override
    public void onCreate() {
        Utils.print("Service OnCreate Called");
        shouldGenerateRandomNumber = true;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.print("Service onStartCommand Called");

        new Thread(new Runnable() {
            @Override
            public void run() {
                generateRandomNumber();
            }
        }).start();

        return START_STICKY;
    }

    private void generateRandomNumber() {

        while (shouldGenerateRandomNumber){
            int randomNumber = new Random().nextInt(100);
            Utils.print(randomNumber);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Utils.print("Service onBind Called");

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Utils.print("Service onUnbind Called");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Utils.print("Service onDestroy Called");

        shouldGenerateRandomNumber = false;
        super.onDestroy();
    }
}
