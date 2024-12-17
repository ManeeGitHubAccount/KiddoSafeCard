package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button getStartedButton = findViewById(R.id.get_started);

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Get Started button clicked");
                // Create an Intent to start the LoginActivity
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                Log.d(TAG, "Intent created to start LoginActivity");
                startActivity(intent);
            }
        }

        );
    }
}
