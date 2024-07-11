package com.example.kiddosafecard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddChildActivity extends AppCompatActivity {
    private EditText editChildName, editDob, editDor, editMotherName, editAddress;
    private RadioGroup radioGroupGender;
    private Spinner spinnerRegHealthDiv;
    final Calendar myCalender = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_child);

        editChildName = findViewById(R.id.edit_child_name);
        editMotherName = findViewById(R.id.edit_mother_name);
        editAddress = findViewById(R.id.edit_address);
        radioGroupGender = findViewById(R.id.radio_group_gender);
        spinnerRegHealthDiv = findViewById(R.id.spinner_reg_health_div);
        Button btnregister = findViewById(R.id.btn_register);
        Button btncancel = findViewById(R.id.btn_cancel);

        editDob = findViewById(R.id.edit_dob);
        editDob.setOnClickListener(v -> new DatePickerDialog(AddChildActivity.this, (view, year, month, dayOfMonth) -> {

            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, month);
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MM-yyyy" ;
            SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat , Locale.US );
            editDob.setText(dateFormat.format(myCalender.getTime()));
        }, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show());


        editDor = findViewById(R.id.edit_dor);
        editDor.setOnClickListener(v -> new DatePickerDialog(AddChildActivity.this, (view, year, month, dayOfMonth) -> {

            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, month);
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MM-yyyy" ;
            SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat , Locale.US );
            editDor.setText(dateFormat.format(myCalender.getTime()));
        }, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show());


        btncancel.setOnClickListener(v -> {
            clearFields();
            navigateToDashboard();
        });

        btnregister.setOnClickListener(v -> navigateToDashboard());
    }

    private void clearFields() {
        editChildName.setText("");
        editDob.setText("");
        editDor.setText("");
        editMotherName.setText("");
        editAddress.setText("");
        radioGroupGender.clearCheck();
        spinnerRegHealthDiv.setSelection(0);
    }

    private void navigateToDashboard() {
        Intent intent = new Intent(AddChildActivity.this, Dashboard.class);
        startActivity(intent);
    }
}
