package com.example.MyBroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.android_ready.utils.Utils;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Utils.print("called");
        Utils.showToast("MyBroadCastReceiver onReceive called ");
    }
}