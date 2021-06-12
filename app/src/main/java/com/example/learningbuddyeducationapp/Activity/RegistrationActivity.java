package com.example.learningbuddyeducationapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityRegisterationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegisterationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_registeration);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, DemoVideo.class);
                startActivity(intent);
            }
        });
    }
}