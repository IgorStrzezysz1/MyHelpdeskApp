package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailEditText, firstNameEditText, lastNameEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page); // <- dopasuj do nazwy pliku XML!

        // Powiązanie elementów z layoutem
        emailEditText = findViewById(R.id.enterEmail);
        firstNameEditText = findViewById(R.id.enterName);
        lastNameEditText = findViewById(R.id.enterSurname);
        passwordEditText = findViewById(R.id.enterPassword);
        confirmPasswordEditText = findViewById(R.id.enterAgainPassword);
        registerButton = findViewById(R.id.buttonRegister);
        backButton = findViewById(R.id.backButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                        password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Hasła się nie zgadzają!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Zarejestrowano pomyślnie!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Obsługa przycisku "Cofnij się"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
