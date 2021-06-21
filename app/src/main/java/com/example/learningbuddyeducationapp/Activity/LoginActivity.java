package com.example.learningbuddyeducationapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    String email,password;
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Thanks For Login",Toast.LENGTH_SHORT);
                email = binding.emailLogin.getText().toString().trim();
                password = binding.passwordLogin.getText().toString();
                if (TextUtils.isEmpty(email))
                {
                    binding.emailLogin.setError("Name is required");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    binding.passwordLogin.setError("Password is required");
                    return;
                }


            }
        });
    }
}