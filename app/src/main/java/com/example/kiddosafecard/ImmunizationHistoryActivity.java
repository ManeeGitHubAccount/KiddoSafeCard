package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ImmunizationHistoryActivity extends AppCompatActivity {

    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization_history); // Ensure you have a corresponding layout file

        btn = findViewById(R.id.btn_back);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ImmunizationHistoryActivity.this,Dashboard.class));
            }
        });

    }

}
