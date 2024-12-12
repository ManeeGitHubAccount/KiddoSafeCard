package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kiddosafecard.fragments.ChildFragment;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageButton registerChildButton = findViewById(R.id.img_btn_reg_child);
        ImageButton immunizationButton = findViewById(R.id.btn_img_immunization);
        ImageButton upcomingDatesButton = findViewById(R.id.btn_img_upcoming_dates);
        ImageButton parentalEduResButton = findViewById(R.id.btn_img_parental_edu_res); // New
        TextView immunizationTextView = findViewById(R.id.txt_immunization);
        TextView registerChildTextView = findViewById(R.id.txt_reg_child);
        TextView upcomingDatesTextView = findViewById(R.id.txt_upcoming_dates);
        TextView parentalEduResTextView = findViewById(R.id.txt_parental_edu_res); // New

        registerChildButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ChildActivity.class);
            startActivity(intent);
        });

        immunizationButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ImmunizationActivity.class);
            startActivity(intent);
        });

        upcomingDatesButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, UpcomingDatesActivity.class);
            startActivity(intent);
        });

        parentalEduResButton.setOnClickListener(v -> { // New
            Intent intent = new Intent(Dashboard.this, EducationActivity.class);
            startActivity(intent);
        });

        immunizationTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ImmunizationActivity.class);
            startActivity(intent);
        });

        registerChildTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ChildFragment.class);
            startActivity(intent);
        });

        upcomingDatesTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, UpcomingDatesActivity.class);
            startActivity(intent);
        });

        parentalEduResTextView.setOnClickListener(v -> { // New
            Intent intent = new Intent(Dashboard.this, EducationActivity.class);
            startActivity(intent);
        });
    }
}
