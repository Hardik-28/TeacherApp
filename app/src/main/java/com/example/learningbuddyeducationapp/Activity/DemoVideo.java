package com.example.learningbuddyeducationapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityDemoVideoBinding;


public class DemoVideo extends AppCompatActivity {
    ActivityDemoVideoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_video);
        binding = ActivityDemoVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}