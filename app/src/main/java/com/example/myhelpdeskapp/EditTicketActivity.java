package com.example.myhelpdeskapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditTicketActivity extends AppCompatActivity {

    private EditText titleEditText, descriptionEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ticket);

        titleEditText = findViewById(R.id.editTextTitle);
        descriptionEditText = findViewById(R.id.editTextDescription);
        saveButton = findViewById(R.id.buttonSave);

        // Pobierz dane z intentu
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        titleEditText.setText(title);
        descriptionEditText.setText(description);

        saveButton.setOnClickListener(v -> {
            // Można zapisać zmiany (do bazy lub listy)
            String updatedTitle = titleEditText.getText().toString();
            String updatedDescription = descriptionEditText.getText().toString();

            Toast.makeText(this, "Zaktualizowano: " + updatedTitle, Toast.LENGTH_SHORT).show();
            finish(); // Wróć
        });
    }
}
