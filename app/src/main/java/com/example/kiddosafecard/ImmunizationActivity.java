package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class ImmunizationActivity extends AppCompatActivity {
    ImageButton btn;
    private Spinner spinnerSelectChild;
    private Spinner spinnerSelectVaccine;
    private EditText editRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization);

        btn = findViewById(R.id.btn_back);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ImmunizationActivity.this,Dashboard.class));
            }
        });

        spinnerSelectChild = findViewById(R.id.spinner_select_child);
        spinnerSelectVaccine = findViewById(R.id.spinner_select_vaccine);
        editRemarks = findViewById(R.id.edit_remarks);
        Button btnClear = findViewById(R.id.btn_clear);
        Button btnHistory = findViewById(R.id.btn_history);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImmunizationHistory();
            }
        });
    }

    private void clearFields() {
        spinnerSelectChild.setSelection(0);
        spinnerSelectVaccine.setSelection(0);
        editRemarks.setText("");
    }

    private void openImmunizationHistory() {
        Intent intent = new Intent(ImmunizationActivity.this, ImmunizationHistoryActivity.class);
        startActivity(intent);
    }


}
