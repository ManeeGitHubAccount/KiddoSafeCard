package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    private ImageButton btn, addChildButton, immunizationButton, upcomingDatesButton, parentalEduResButton, immunizationHistoryButton ,upcomingDateHistory;
    //TextView immunizationTextView, addChildText, upcomingDatesTextView, parentalEduResTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Initialize buttons and text views
        btn = findViewById(R.id.btn_logout);
        addChildButton = findViewById(R.id.btn_img_reg_child);
        immunizationButton = findViewById(R.id.btn_img_immunization);
        upcomingDatesButton = findViewById(R.id.btn_img_upcoming_dates);
        parentalEduResButton = findViewById(R.id.btn_img_parental_edu_res);
        immunizationHistoryButton = findViewById(R.id.btn_img_immunizationHistory);
        upcomingDateHistory = findViewById(R.id.btn_img_upcomingHistory);


        // Assign click listeners
        btn.setOnClickListener(view -> startActivity(new Intent(Dashboard.this, LogoutActivity.class)));
        addChildButton.setOnClickListener(v -> navigateTo(AddActivity.class, "Navigating to Add Child"));
        immunizationButton.setOnClickListener(v -> navigateTo(ImmunizationActivity.class, "Navigating to Immunization"));
        immunizationHistoryButton.setOnClickListener(v -> navigateTo(User.class, "Navigating to Immunization History"));
        upcomingDateHistory.setOnClickListener(v -> navigateTo(User2.class, "Navigating to Upcoming History"));
        upcomingDatesButton.setOnClickListener(v -> navigateTo(UpcomingDatesActivity.class, "Navigating to Upcomig Dates"));
        parentalEduResButton.setOnClickListener(v -> navigateTo(EducationActivity.class, "Navigating to Parental Education and Resources"));
    }

    private void navigateTo(Class<?> activityClass, String toastMessage) {
        if (toastMessage != null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(Dashboard.this,activityClass);
        startActivity(intent);
    }
}
