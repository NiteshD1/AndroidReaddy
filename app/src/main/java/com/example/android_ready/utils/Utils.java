package com.example.android_ready.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.android_ready.MainApplication;


public class Utils {

    public static void showToast(String message){
        Toast.makeText(MainApplication.getContext(),message,Toast.LENGTH_LONG).show();
    }

    public static void print(Object message){
        Log.d("TAG", "print: " + message);
    }
}
