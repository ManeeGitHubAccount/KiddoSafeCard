package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText editemail , editPassword ;
    private FirebaseAuth fAuth; // Initialize FirebaseAuth instance
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialize FirebaseAuth
        fAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        editemail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        progressBar = findViewById(R.id.progressBar2);

        // Login Button
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(v -> {
            String email = editemail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            // Validate input fields
            if (TextUtils.isEmpty(email)) {
                editemail.setError("Email is required");
                return;
            }
            // Validate email format
            if (!email.matches("^[\\w.%+-]+@gmail\\.com$")) {
                editemail.setError("Email must be a valid Gmail address (e.g., example@gmail.com)");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                editPassword.setError("Password is required");
                return;
            }

            // Show progress bar
            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                progressBar.setVisibility(View.GONE); // Hide progress bar

                if (task.isSuccessful()) {
                    Log.d("LoginActivity", "Sign in successful");
                    Toast.makeText(LoginActivity.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                    finish(); // Close LoginActivity
                } else {
                    Log.e("LoginActivity", "Error: " + task.getException().getMessage());
                    Toast.makeText(LoginActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        // Register TextView
        TextView txt_register = findViewById(R.id.txt_register);
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "Register TextView clicked");
                Intent intent = new Intent(LoginActivity.this, RegisterScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
