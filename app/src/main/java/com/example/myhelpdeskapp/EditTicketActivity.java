package com.example.myhelpdeskapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTicketActivity extends AppCompatActivity {

    private EditText titleEditText, descriptionEditText;
    private Button saveButton, backButton;
    private long ticketId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ticket);

        titleEditText = findViewById(R.id.editTextTitle);
        descriptionEditText = findViewById(R.id.editTextDescription);
        saveButton = findViewById(R.id.buttonSave);
        backButton = findViewById(R.id.buttonBack);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        ticketId = getIntent().getLongExtra("ticketId", -1);

        titleEditText.setText(title);
        descriptionEditText.setText(description);

        saveButton.setOnClickListener(v -> {
            String updatedTitle = titleEditText.getText().toString();
            String updatedDescription = descriptionEditText.getText().toString();

            Ticket updatedTicket = new Ticket(ticketId, updatedTitle, updatedDescription);

            RetrofitClient.getApiService().updateTicket(ticketId, updatedTicket).enqueue(new Callback<Ticket>() {
                @Override
                public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(EditTicketActivity.this, "Zgłoszenie zaktualizowane!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(EditTicketActivity.this, "Błąd aktualizacji!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Ticket> call, Throwable t) {

                    Toast.makeText(EditTicketActivity.this, "Błąd połączenia!", Toast.LENGTH_SHORT).show();
                }
            });
        });

        backButton.setOnClickListener(v -> finish());
    }
}
