package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ImmunizationActivity extends AppCompatActivity {
    private EditText editChildname, editNameVaccine, editRemarks;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private ProgressBar progressBar;
    private Button btnSave, btnHistory, btnClear;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization);

        // Initialize FirebaseAuth and Firestore instances
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Initialize UI elements
        btnBack = findViewById(R.id.btn_back);
        btnSave = findViewById(R.id.btn_save);
        btnClear = findViewById(R.id.btn_clear);
        btnHistory = findViewById(R.id.btn_history);
        editChildname = findViewById(R.id.select_child);
        editNameVaccine = findViewById(R.id.select_vaccine);
        editRemarks = findViewById(R.id.edit_remarks);
        progressBar = findViewById(R.id.progressBar);

        // Back button listener
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ImmunizationActivity.this, Dashboard.class);
            startActivity(intent);
        });

        // History button listener
        btnHistory.setOnClickListener(view -> {
            Intent intent = new Intent(ImmunizationActivity.this, MyAdapter.class);
            startActivity(intent);
        });

        // Save button listener
        btnSave.setOnClickListener(v -> vaccination());

        // Clear button listener
        btnClear.setOnClickListener(v -> clearFields());
    }

    private void vaccination() {
        String childNameValue = editChildname.getText().toString().trim();
        String nameVaccinationValue = editNameVaccine.getText().toString().trim();
        String remarksValue = editRemarks.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(childNameValue)) {
            editChildname.setError("Child Name is required");
            return;
        }
        if (TextUtils.isEmpty(nameVaccinationValue)) {
            editNameVaccine.setError("Name of Vaccination is required");
            return;
        }
        if (TextUtils.isEmpty(remarksValue)) {
            editRemarks.setError("Remarks are required");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Store data in Firestore
        Map<String, Object> vaccinationData = new HashMap<>();
        vaccinationData.put("childName", childNameValue);
        vaccinationData.put("vaccination", nameVaccinationValue);
        vaccinationData.put("remarks", remarksValue);

        // Add vaccination details to Firestore collection
        fStore.collection("vaccination").add(vaccinationData).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                Toast.makeText(ImmunizationActivity.this, "Vaccination Details added Successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(ImmunizationActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        editChildname.setText("");
        editNameVaccine.setText("");
        editRemarks.setText("");
    }
}
