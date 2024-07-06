package com.example.kiddosafecard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kiddosafecard.R;

public class AddChildActivity extends AppCompatActivity {

    private EditText editChildName, editDob, editDor, editMotherName, editAddress;
    private RadioGroup radioGroupGender;
    private Spinner spinnerRegHealthDiv, spinnerNoOfChildren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_child);

        // Initialize UI elements
        editChildName = findViewById(R.id.edit_child_name);
        editDob = findViewById(R.id.edit_dob);
        editDor = findViewById(R.id.edit_dor);
        editMotherName = findViewById(R.id.edit_mother_name);
        editAddress = findViewById(R.id.edit_address);
        radioGroupGender = findViewById(R.id.radio_group_gender);
        spinnerRegHealthDiv = findViewById(R.id.spinner_reg_health_div);
        spinnerNoOfChildren = findViewById(R.id.spinner_no_of_children);
        Button btnRegister = findViewById(R.id.btn_register);
        Button btnCancel = findViewById(R.id.btn_cancel);

        // Set listeners for buttons
        btnRegister.setOnClickListener(v -> registerChild());

        btnCancel.setOnClickListener(v -> cancelRegistration());
    }

    private void registerChild() {
        String childName = editChildName.getText().toString();
        String dob = editDob.getText().toString();
        String dor = editDor.getText().toString();
        String motherName = editMotherName.getText().toString();
        String address = editAddress.getText().toString();
        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        String regHealthDiv = spinnerRegHealthDiv.getSelectedItem().toString();
        String noOfChildren = spinnerNoOfChildren.getSelectedItem().toString();

        // Validate inputs (simplified)
        if (childName.isEmpty() || dob.isEmpty() || dor.isEmpty() || motherName.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process registration (e.g., save to database)
        Toast.makeText(this, "Child registered successfully", Toast.LENGTH_SHORT).show();

        // Optionally, clear fields after successful registration
        clearFields();
    }

    private void cancelRegistration() {
        // Optionally, add confirmation dialog here
        Toast.makeText(this, "Registration cancelled", Toast.LENGTH_SHORT).show();
        finish();  // Close the activity
    }

    private void clearFields() {
        editChildName.setText("");
        editDob.setText("");
        editDor.setText("");
        editMotherName.setText("");
        editAddress.setText("");
        radioGroupGender.clearCheck();
        spinnerRegHealthDiv.setSelection(0);
        spinnerNoOfChildren.setSelection(0);
    }
}
