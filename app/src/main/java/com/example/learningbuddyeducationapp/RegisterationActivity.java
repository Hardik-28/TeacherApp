package com.example.learningbuddyeducationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
public class RegisterationActivity extends AppCompatActivity {
       Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        button2 = findViewById(R.id.submit);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterationActivity.this,DemoVideo.class);
                startActivity(intent);
            }
        });
    }
}