package com.example.android_ready;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public abstract class BaseAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TESTING", "CREATED: " + getClass().getSimpleName() + " -- TASK ID: " + getTaskId());
        if (Build.VERSION.SDK_INT >= 29) {
            ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            List<ActivityManager.AppTask> tasks = activityManager.getAppTasks();
            Log.i("TESTING",  " -- Activity Count in Task: " + tasks.get(0).getTaskInfo().numActivities);
            Log.i("TESTING",  " -- Top Activity in Task: " + tasks.get(0).getTaskInfo().topActivity.getClassName());

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TESTING", "DESTROYED: " + getClass().getSimpleName() + " -- TASK ID: " + getTaskId());
        if (Build.VERSION.SDK_INT >= 29) {
            ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            List<ActivityManager.AppTask> tasks = activityManager.getAppTasks();
            Log.i("TESTING",  " -- Activity Count in Task: " + tasks.get(0).getTaskInfo().numActivities);
            Log.i("TESTING",  " -- Top Activity in Task: " + tasks.get(0).getTaskInfo().topActivity.getClassName());

        }
    }
}