package com.example.learningbuddyeducationapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityRegisterationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
                Toast.makeText(RegistrationActivity.this, "Thanks for registeration", Toast.LENGTH_SHORT).show();
                fullName =binding.editTextTextPersonName.getText().toString().trim();
                email= binding.emailAddress.getText().toString().trim();
                phoneNumber= binding.editTextPhone.getText().toString().trim();
                password = binding.editTextTextPassword.getText().toString();
                if (TextUtils.isEmpty(fullName))
                {
                    binding.editTextTextPersonName.setError("Name is required");
                    return;
                }
                if (TextUtils.isEmpty(email))
                {
                    binding.emailAddress.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(phoneNumber))
                {
                    binding.editTextPhone.setError("Mobile Number is required");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    binding.editTextTextPassword.setError("Password is required");
                    return;
                }
                if (password.length()<6)
                {
                    binding.editTextTextPassword.setError("Password must be of 6 character or greater than 6");
                    return;
                }
                signup(email,password);

            }
        });
    }
    private void signup(String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "User created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}