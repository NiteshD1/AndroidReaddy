package com.example.android_ready;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ready.Utils.Constants;
import com.example.android_ready.Utils.Utils;
import com.example.android_ready.databinding.ActivityMainBinding;
import com.example.android_ready.models.Student;
import com.example.android_ready.models.StudentParcelable;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent intent = result.getData();
                            Utils.showToast(intent.getStringExtra(Constants.KEY_NAME));
                        }
                    }
                }
        );
    }

    private void setupButtons() {
        binding.buttonSendDataWithIntentOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DemoActivity.class);
                intent.putExtra(Constants.KEY_NAME,"Ram Kapoor");
                //startActivity(intent);
                activityResultLauncher.launch(intent);
            }
        });

        binding.buttonSendDataWithBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DemoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.KEY_NAME,"Shiv kumar");
                bundle.putString(Constants.DOB,"22/02/1998");
                intent.putExtra(Constants.KEY_BUNDLE,bundle);
                startActivity(intent);
            }
        });

        binding.buttonSendCustomObjectWithSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DemoActivity.class);

                Student student = new Student("Rohit Kapoor","01/01/1998");
                intent.putExtra(Constants.KEY_SERIALIZABLE,student);
                startActivity(intent);
            }
        });

        binding.buttonSendCustomObjectWithParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DemoActivity.class);
                StudentParcelable studentParcelable = new StudentParcelable("Akshay Kapoor","23/01/1998");
                intent.putExtra(Constants.KEY_PARCELABLE,studentParcelable);
                startActivity(intent);
            }
        });
    }

}