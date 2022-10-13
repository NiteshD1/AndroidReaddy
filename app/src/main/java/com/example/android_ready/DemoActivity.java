package com.example.android_ready;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ready.Utils.Constants;
import com.example.android_ready.databinding.ActivityDemoBinding;
import com.example.android_ready.models.Student;
import com.example.android_ready.models.StudentParcelable;

public class DemoActivity extends AppCompatActivity {

    ActivityDemoBinding binding;

    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        if(intent != null){
            if(intent.getStringExtra(Constants.KEY_NAME) != null){
                message = intent.getStringExtra(Constants.KEY_NAME);
                binding.textViewIntentData.setText(message);
                setResult(Activity.RESULT_OK,intent);
            }
            if(intent.getBundleExtra(Constants.KEY_BUNDLE) != null){
                Bundle bundle = intent.getBundleExtra(Constants.KEY_BUNDLE);
                message = "Name : " +bundle.getString(Constants.KEY_NAME) + " Dob : " + bundle.getString(Constants.DOB);
                binding.textViewIntentData.setText(message);
            }
            if(intent.getSerializableExtra(Constants.KEY_SERIALIZABLE) != null){
                Student student = (Student) intent.getSerializableExtra(Constants.KEY_SERIALIZABLE);
                message = "Name : " + student.getName() + " Dob : " + student.getDob();
                binding.textViewIntentData.setText(message);
            }
            if(intent.getParcelableExtra(Constants.KEY_PARCELABLE) != null){
                StudentParcelable studentParcelable = (StudentParcelable) intent.getParcelableExtra(Constants.KEY_PARCELABLE);
                message = "Name : " + studentParcelable.getName() + " Dob : " + studentParcelable.getDob();
                binding.textViewIntentData.setText(message);
            }
        }

    }

}