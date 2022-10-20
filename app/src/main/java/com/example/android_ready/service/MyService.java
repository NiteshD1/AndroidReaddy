package com.example.android_ready.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.android_ready.utils.Utils;

public class MyService extends Service {

    @Override
    public void onCreate() {
        Utils.print("Service OnCreate Called");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.print("Service onStartCommand Called");

        return START_STICKY;
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

        super.onDestroy();
    }
}
