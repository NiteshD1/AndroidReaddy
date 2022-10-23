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
        }
    }
}