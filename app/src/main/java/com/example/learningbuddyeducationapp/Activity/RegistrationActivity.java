package com.example.learningbuddyeducationapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.learningbuddyeducationapp.R;
import com.example.learningbuddyeducationapp.databinding.ActivityRegisterationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegisterationBinding binding;
    String fullName,email,phoneNumber,password,confirmPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private final FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        binding = ActivityRegisterationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressBar = new ProgressDialog(this);
        progressBar.setMessage("Sign Up...");
        progressBar.setCancelable(false);
        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }
    private void signup()
    {
        fullName =binding.nameRegister.getText().toString().trim();
        email= binding.emailRegister.getText().toString().trim();
        phoneNumber= binding.numberRegister.getText().toString().trim();
        password = binding.passwordRegister.getText().toString();
        confirmPassword = binding.confirmPasswordRegister.getText().toString();
        if (TextUtils.isEmpty(fullName))
        {
            binding.nameRegister.setError("Name is required");
        }
        else if (TextUtils.isEmpty(phoneNumber))
        {
            binding.numberRegister.setError("Mobile Number is required");
        }
        else if (TextUtils.isEmpty(email))
        {
            binding.emailRegister.setError("Email is required");

        }
        else if(!email.trim().matches(emailPattern)){
            binding.emailRegister.setError("Email is Not Valid");
        }
        else if (TextUtils.isEmpty(password))
        {
            binding.passwordRegister.setError("Password is required");
        }
        else if(password.length()<6)
        {
            binding.passwordRegister.setError("Password must be of 6 character or greater than 6");
        }
        else if (TextUtils.isEmpty(confirmPassword))
        {
            binding.confirmPasswordRegister.setError("Password is required");
        }
        else if(!confirmPassword.equals(password)){
            binding.confirmPasswordRegister.setError("Password and Confirm Password must be same");
        }
        else {
            progressBar.show();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                DocumentReference documentReference = fStore.collection("Demo").document(Objects.requireNonNull(mAuth.getUid()));
                                Map<String, Object> teachers = new HashMap<>();
                                teachers.put("FullName", fullName);
                                teachers.put("Email", email);
                                teachers.put("UserId", mAuth.getUid());
                                teachers.put("PhoneNumber", phoneNumber);
                                documentReference.set(teachers).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        updateUI(user);
                                        progressBar.dismiss();
                                    }
                                });
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                updateUI(null);
                                progressBar.dismiss();
                            }
                        }
                    });
        }
    }

    private void updateUI(FirebaseUser user){
        if(user != null){
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(RegistrationActivity.this, "Try Again Some Time!", Toast.LENGTH_SHORT).show();
        }
    }
}
