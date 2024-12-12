package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText editUsername, editPassword, editConfirmPassword, editEmail, editMobileNo;
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn = findViewById(R.id.btn_back);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        editConfirmPassword = findViewById(R.id.edit_confirm_password);
        editEmail = findViewById(R.id.edit_email);
        editMobileNo = findViewById(R.id.edit_mobile_no);


        Button registerButton = findViewById(R.id.btn_register);
        registerButton.setOnClickListener(v -> {

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });



        Button cancelButton = findViewById(R.id.btn_cancel);
        cancelButton.setOnClickListener(v -> {
            clearFields();
            navigateToLogin();
        });

        // Set up the sign in text view click listener to navigate to Login screen
        TextView signInTextView = findViewById(R.id.txt_sign_in);
        signInTextView.setOnClickListener(v -> {
            // Create an intent to start the LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void clearFields() {
        editUsername.setText("");
        editPassword.setText("");
        editConfirmPassword.setText("");
        editEmail.setText("");
        editMobileNo.setText("");
    }

    private void navigateToLogin()
    {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
