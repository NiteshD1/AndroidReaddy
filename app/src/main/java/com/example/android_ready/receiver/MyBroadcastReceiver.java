package com.example.android_ready.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.android_ready.utils.Utils;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Utils.showToast("Airplane Mode Changed");
        }else if(intent.getAction().equals("com.example.android_ready.MY_NOTIFICATION")){
            Utils.showToast(intent.getStringExtra("data"));
        }
    }
}
