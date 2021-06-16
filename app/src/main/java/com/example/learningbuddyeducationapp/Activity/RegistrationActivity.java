package com.example.learningbuddyeducationapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityRegisterationBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegisterationBinding binding;
    String fullName,email,phoneNumber,password;
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_registeration);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName =binding.editTextTextPersonName.getText().toString().trim();
                email= binding.emailAddress.getText().toString().trim();
                phoneNumber= binding.editTextPhone.getText().toString().trim();
                if (TextUtils.isEmpty(fullName))
                {
                    binding.editTextTextPersonName.setError("Name is required");
                }
                if (TextUtils.isEmpty(email))
                {
                    binding.emailAddress.setError("Email is required");
                }
                if (TextUtils.isEmpty(phoneNumber))
                {
                    binding.editTextPhone.setError("Mobile Number is required");
                }
                
            }
        });
    }
}