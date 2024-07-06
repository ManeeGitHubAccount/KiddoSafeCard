package com.example.kiddosafecard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.kiddosafecard.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavBarActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_nav);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            loadFragment(new DashboardFragment());
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.navigation_baby:
                    selectedFragment = new AddChildFragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.navigation_feedback:
                    selectedFragment = new FeedbackFragment();
                    break;
                case R.id.navigation_logout:
                    selectedFragment = new LogoutFragment();
                    break;
                default:
                    return false;
            }
            loadFragment(selectedFragment);
            return true;
        });
    }
    private void loadFragment(Fragment fragment) {
        // Load fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.bottom_navigation, fragment)
                .commit();
    }
}