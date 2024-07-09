package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ImmunizationActivity extends AppCompatActivity {

    private Button btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization); // Make sure to create immunization.xml layout

        btnHistory = findViewById(R.id.btn_history);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ImmunizationHistoryActivity
                Intent intent = new Intent(ImmunizationActivity.this, ImmunizationHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
