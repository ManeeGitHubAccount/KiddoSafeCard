package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageButton registerChildButton = findViewById(R.id.img_btn_reg_child);
        ImageButton immunizationButton = findViewById(R.id.btn_img_immunization);
        TextView immunizationTextView = findViewById(R.id.txt_immunization);

        registerChildButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, AddChildActivity.class);
            startActivity(intent);
        });

        immunizationButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ImmunizationActivity.class);
            startActivity(intent);
        });

        immunizationTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ImmunizationActivity.class);
            startActivity(intent);
        });
    }
}
