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

public class UpcomingDatesActivity extends AppCompatActivity {
    private EditText editVaccineame, editDate, editTime , editRemarks;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private ProgressBar progressBar;
    private Button btnSave,btnClear;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcomingdates);

        // Initialize FirebaseAuth and Firestore instances
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Initialize UI elements
        btnBack = findViewById(R.id.btn_back);
        btnSave = findViewById(R.id.btn_save);
        btnClear = findViewById(R.id.btn_clear);
        editVaccineame = findViewById(R.id.edit_vaccine);
        editDate = findViewById(R.id.select_vaccine);
        editTime = findViewById(R.id.edit_time);
        editRemarks = findViewById(R.id.edit_remarks);
        progressBar = findViewById(R.id.progressBar);

        // Back button listener
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(UpcomingDatesActivity.this, Dashboard.class);
            startActivity(intent);
        });

        // Save button listener
        btnSave.setOnClickListener(v -> upcomingDates());

        // Clear button listener
        btnClear.setOnClickListener(v -> clearFields());
    }

    private void upcomingDates() {
        String vaccinationNameValue = editVaccineame.getText().toString().trim();
        String dateVaccinationValue = editDate.getText().toString().trim();
        String timeVaccinationValue = editTime.getText().toString().trim();
        String remarksValue = editRemarks.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(vaccinationNameValue)) {
            editVaccineame.setError("Vaccination Name is required");
            return;
        }
        if (TextUtils.isEmpty(dateVaccinationValue)) {
            editDate.setError("Vaccination Date is required");
            return;
        }
        if (TextUtils.isEmpty(timeVaccinationValue)) {
            editTime.setError("Vaccination Time is required");
            return;
        }
        if (TextUtils.isEmpty(remarksValue)) {
            editRemarks.setError("Remarks are required");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Store data in Firestore
        Map<String, Object> upccomingVaccineDate = new HashMap<>();
        upccomingVaccineDate.put("Vaccine Name", vaccinationNameValue);
        upccomingVaccineDate.put("Date", dateVaccinationValue);
        upccomingVaccineDate.put("Time", timeVaccinationValue);
        upccomingVaccineDate.put("Remarks", remarksValue);

        // Add vaccination details to Firestore collection
        fStore.collection("Upcoming Dates").add(upccomingVaccineDate).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                Toast.makeText(UpcomingDatesActivity.this, "Upcoming Dates added Successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(UpcomingDatesActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        editVaccineame.setText("");
        editDate.setText("");
        editTime.setText("");
        editRemarks.setText("");
    }
}
