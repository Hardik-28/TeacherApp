package com.example.learningbuddyeducationapp.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.learningbuddyeducationapp.Activity.LoginActivity;
import com.example.learningbuddyeducationapp.Activity.MainActivity;
import com.example.learningbuddyeducationapp.Activity.RegistrationActivity;
import com.example.learningbuddyeducationapp.Adapter.SimpleFragmentPagerAdapter;
import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    SimpleFragmentPagerAdapter swipePageAdapter;
    String prevStarted = "yes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        swipePageAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(swipePageAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            moveToSecondary();
        }
    }

    private void moveToSecondary() {Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}