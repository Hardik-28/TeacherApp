package com.example.learningbuddyeducationapp.SplashScreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.learningbuddyeducationapp.databinding.FragmentSplashScreen2Binding;


public class SplashScreenFragment2 extends Fragment {
    FragmentSplashScreen2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashScreen2Binding.inflate(inflater,container,false);
        return binding.getRoot() ;
    }
}