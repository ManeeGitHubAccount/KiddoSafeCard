package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.kiddosafecard.R;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageButton registerChildButton = findViewById(R.id.img_btn_reg_child);

        registerChildButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, AddChildActivity.class);
            startActivity(intent);
        });

    }
}
