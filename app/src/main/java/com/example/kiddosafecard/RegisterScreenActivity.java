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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterScreenActivity extends AppCompatActivity {
    private TextView editUsername, editPassword, editConfirmPassword, editEmail, editMobileNo;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;
    private ImageButton btn_cancel,btn_register,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // Initialize FirebaseAuth instance
        fAuth = FirebaseAuth.getInstance();


        // Initialize UI elements
        btn_back = findViewById(R.id.btn_back);
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        editConfirmPassword = findViewById(R.id.edit_confirm_password);
        editEmail = findViewById(R.id.edit_email);
        editMobileNo = findViewById(R.id.edit_mobile_no);
        progressBar = findViewById(R.id.progressBar);

        // Back button listener
        btn_back.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterScreenActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Register button listener
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(v -> registerUser());
    }
    private void registerUser() {

        String name = editUsername.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String confirmPassword = editConfirmPassword.getText().toString().trim();
        String mobile_number = editMobileNo.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            editUsername.setError("User Name is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editPassword.setError("Password is required");
            return;
        }

        if (password.length() < 6) {
            editPassword.setError("Password must be >= 6 characters");
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            editConfirmPassword.setError("Confirm Password is required");
            return;
        }
        if (password.length() < 6) {
            editConfirmPassword.setError("Confirm Password must be >= 6 characters");
            return;
        }
        if (!password.equals(confirmPassword)) {
            editConfirmPassword.setError("Passwords do not match");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editEmail.setError("Email is required");
            return;
        }
        // Validate email format
        if (!email.matches("^[\\w.%+-]+@gmail\\.com$")) {
            editEmail.setError("Email must be a valid Gmail address (e.g., example@gmail.com)");
            return;
        }

        if (TextUtils.isEmpty(mobile_number)) {
            editMobileNo.setError("Mobile Number is required");
            return;
        }
        // Check if the mobile number has exactly 10 digits
        if (!mobile_number.matches("\\d{10}")) {
            editMobileNo.setError("Mobile Number must be exactly 10 digits.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterScreenActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                } else{
                    Toast.makeText(RegisterScreenActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

//        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task ->
//        {
//            progressBar.setVisibility(View.GONE);
//            if (task.isSuccessful())
//            {
//                Toast.makeText(RegisterScreenActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                finish();
//            } else
//            {
//                Toast.makeText(RegisterScreenActivity.this, "Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}