package com.example.MyBroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.android_ready.utils.Utils;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            Utils.showToast("Airplane Mode Changed");
            Utils.print(intent);
        }else if(intent.getAction() == "com.example.android_ready.MY_NOTIFICATION"){
            Utils.showToast(intent.getStringExtra("data"));
        }
    }
}