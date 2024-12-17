package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    // Declare the buttons
    private Button btnLogout;
    private Button btnCancelLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logoutscreen);

        // Initialize the buttons
        btnLogout = findViewById(R.id.btn_cancel_logout);
        btnCancelLogout = findViewById(R.id.btn_logout);

        // Set onClickListener for the "Logout" button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Welcome screen
                Intent intent = new Intent(LogoutActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();  // Finish this activity to remove it from the back stack
            }
        });

        // Set onClickListener for the "Cancel" button
        btnCancelLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Dashboard
                Intent intent = new Intent(LogoutActivity.this, Dashboard.class);
                startActivity(intent);
                finish();  // Finish this activity to remove it from the back stack
            }
        });
    }
}
