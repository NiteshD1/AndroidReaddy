package com.example.android_ready.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.android_ready.MainActivity;
import com.example.android_ready.R;
import com.example.android_ready.utils.Utils;

import java.util.Random;


public class MyService extends Service {

    boolean shouldGenerateRandomNumber = false;
    int currentRandomNumber = -1;

    @Override
    public void onCreate() {
        Utils.print("Service OnCreate Called");
        shouldGenerateRandomNumber = true;

        super.onCreate();
    }

    private void generateRandomNumber() {
        Utils.print("generateRandomNumber called");
        while (shouldGenerateRandomNumber){
            int randomNumber = new Random().nextInt(100);
            currentRandomNumber = randomNumber;
            Utils.print(randomNumber);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.print("Service onStartCommand Called");

        Intent notificationIntent = new Intent(MyService.this,MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new Notification.Builder(this)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_message))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);
        new Thread(new Runnable() {
            @Override
            public void run() {
                generateRandomNumber();
            }
        }).start();

        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        Utils.print("Service onDestroy Called");
        shouldGenerateRandomNumber = false;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
