package com.example.learningbuddyeducationapp.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.learningbuddyeducationapp.SplashScreen.SplashScreenFragment1;
import com.example.learningbuddyeducationapp.SplashScreen.SplashScreenFragment2;
import com.example.learningbuddyeducationapp.SplashScreen.SplashScreenFragment3;

public class SimpleFragmentPagerAdapter
        extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(
            FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new SplashScreenFragment1();
        }
        else if (position == 1) {
            return new SplashScreenFragment2();
        }
        else {
            return new SplashScreenFragment3();
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}
