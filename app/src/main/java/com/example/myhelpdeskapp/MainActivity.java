package com.example.myhelpdeskapp;

import android.content.Intent; // 🔧 <- TO BYŁO BRAKUJĄCE!
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText loginText, passwordEditText;
    private Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_app_activity);

        // Inicjalizacja pól z layoutu XML
        loginText = findViewById(R.id.loginText);
        passwordEditText = findViewById(R.id.passwordEditText);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Obsługa przycisku "Login"
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = loginText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (login.equals("admin") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Logowanie udane!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nieprawidłowe dane logowania", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Przejście do ekranu rejestracji
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
