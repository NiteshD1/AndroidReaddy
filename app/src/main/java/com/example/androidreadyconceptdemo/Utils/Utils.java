package com.example.androidreadyconceptdemo.Utils;

import android.widget.Toast;

import com.example.androidreadyconceptdemo.MainApplication;


public class Utils {

    public static void showToast(String message){
        Toast.makeText(MainApplication.getContext(),message,Toast.LENGTH_LONG).show();
    }
}
