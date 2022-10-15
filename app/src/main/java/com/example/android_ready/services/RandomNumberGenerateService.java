package com.example.android_ready.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.android_ready.utils.Utils;

import java.util.Random;


public class RandomNumberGenerateService extends Service {

    boolean shouldGenerateRandomNumber = false;
    int currentRandomNumber = -2;
    IBinder iBinder;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                generateRandomNumber();
            }
        }).start();

        return START_STICKY;
    }

    public int getRandomNumber() {
        return currentRandomNumber;
    }

    public class ServiceBinder extends Binder{
        public RandomNumberGenerateService getRandomNumberGenerateServiceObject(){
            return RandomNumberGenerateService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Utils.print("Service onBind Called");
        new Thread(new Runnable() {
            @Override
            public void run() {
                generateRandomNumber();
            }
        }).start();

        iBinder = new ServiceBinder();
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Utils.print("Service onUnbind Called");

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Utils.print("Service onRebind Called");

        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Utils.print("Service onDestroy Called");
        shouldGenerateRandomNumber = false;
        super.onDestroy();
    }
}
