package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    private TextView editChildName, editDob, editDateOfReg, editMotherName, editAddress, editRegHealthDivision, editNoOfChildren;
    private FirebaseFirestore fStore;
    private ProgressBar progressBar;
    private Button btn_reg, btn_cancel;
    private ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_child_screen);

        // Initialize UI elements
        editChildName = findViewById(R.id.edit_child_name);
        editDob = findViewById(R.id.edit_dob);
        editDateOfReg = findViewById(R.id.edit_dor);
        editMotherName = findViewById(R.id.edit_mother_name);
        editAddress = findViewById(R.id.edit_address);
        editRegHealthDivision = findViewById(R.id.reg_health_div);
        editNoOfChildren = findViewById(R.id.no_of_children);
        progressBar = findViewById(R.id.progressBar);
        btn_reg = findViewById(R.id.btn_register);
        btn_cancel = findViewById(R.id.btn_cancel);
        btnback = findViewById(R.id.btn_back);

        // Initialize Firestore instance
        fStore = FirebaseFirestore.getInstance();

        // Back button listener
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(AddActivity.this, Dashboard.class);
            startActivity(intent);
        });

        // Register button listener
        btn_reg.setOnClickListener(v -> registerChild());

        // Cancel button listener
        btn_cancel.setOnClickListener(v -> clearFields());
    }

    private void registerChild() {
        String childNameValue = editChildName.getText().toString().trim();
        String dobValue = editDob.getText().toString().trim();
        String dateOfRegValue = editDateOfReg.getText().toString().trim();
        String motherNameValue = editMotherName.getText().toString().trim();
        String addressValue = editAddress.getText().toString().trim();
        String regHealthDivValue = editRegHealthDivision.getText().toString().trim();
        String noOfChildrenValue = editNoOfChildren.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(childNameValue)) {
            editChildName.setError("Child Name is required");
            return;
        }
        if (TextUtils.isEmpty(dobValue)) {
            editDob.setError("Date of Birth is required");
            return;
        }
        if (TextUtils.isEmpty(dateOfRegValue)) {
            editDateOfReg.setError("Date of Registration is required");
            return;
        }
        if (TextUtils.isEmpty(motherNameValue)) {
            editMotherName.setError("Mother Name is required");
            return;
        }
        if (TextUtils.isEmpty(addressValue)) {
            editAddress.setError("Address is required");
            return;
        }
        if (TextUtils.isEmpty(regHealthDivValue)) {
            editRegHealthDivision.setError("Regional Health Division is required");
            return;
        }
        if (TextUtils.isEmpty(noOfChildrenValue)) {
            editNoOfChildren.setError("No of Children is required");
            return;
        }

        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Store data in Firestore
        Map<String, Object> childData = new HashMap<>();
        childData.put("childName", childNameValue);
        childData.put("dob", dobValue);
        childData.put("dateOfRegistration", dateOfRegValue);
        childData.put("motherName", motherNameValue);
        childData.put("address", addressValue);
        childData.put("registeredHealthDivision", regHealthDivValue);
        childData.put("numberOfChildren", noOfChildrenValue);

        fStore.collection("children").add(childData).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE); // Hide progress bar
            if (task.isSuccessful()) {
                Toast.makeText(AddActivity.this, "Child Registered Successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(AddActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            progressBar.setVisibility(View.GONE); // Hide progress bar on failure
            Toast.makeText(AddActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    private void clearFields() {
        editChildName.setText("");
        editDob.setText("");
        editDateOfReg.setText("");
        editMotherName.setText("");
        editAddress.setText("");
        editRegHealthDivision.setText("");
        editNoOfChildren.setText("");
    }
}
