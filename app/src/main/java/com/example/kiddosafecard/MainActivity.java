package com.example.kiddosafecard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kiddosafecard.databinding.ActivityMainBinding;
import com.example.kiddosafecard.fragments.ChildFragment;
import com.example.kiddosafecard.fragments.FeedbackFragment;
import com.example.kiddosafecard.fragments.HomeFragment;
import com.example.kiddosafecard.fragments.LogoutFragment;
import com.example.kiddosafecard.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new ChildFragment());
        binding.bottomNavigation.setBackground(null);

        binding.bottomNavigation.setOnItemSelectedListener(item ->
        {
            switch (item.getItemId()) {
                case R.id.navigation_baby:
                    replaceFragment(new ChildFragment());
                    break;

                case R.id.navigation_feedback:
                    replaceFragment(new FeedbackFragment());
                    break;

                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.navigation_logout:
                    replaceFragment(new LogoutFragment());
                    break;

                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
