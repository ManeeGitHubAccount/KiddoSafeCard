package com.example.kiddosafecard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private ImageButton btnLogin;
    private TextView txt_register;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Login Button
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("LoginActivity", "Login button clicked");
                Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });

      // Register TextView
        TextView txt_register = findViewById(R.id.txt_register);
        txt_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("LoginActivity", "Register TextView clicked");
                Intent intent = new Intent(LoginActivity.this, RegisterScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}

