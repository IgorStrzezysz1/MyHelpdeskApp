package com.example.myhelpdeskapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTicketActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription, editTextContact;
    private Button buttonSave, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reports);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextContact = findViewById(R.id.editTextContact);
        buttonSave = findViewById(R.id.buttonSave);
        buttonBack = findViewById(R.id.buttonBack);

        buttonSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            String contact = editTextContact.getText().toString();

            Ticket ticket = new Ticket(title, description, "active", contact);

            RetrofitClient.getApiService().addTicket(ticket).enqueue(new Callback<Ticket>() {
                @Override
                public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(AddTicketActivity.this, "Zgłoszenie dodane", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddTicketActivity.this, "Błąd zapisu zgłoszenia", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Ticket> call, Throwable t) {
                    Toast.makeText(AddTicketActivity.this, "Błąd połączenia z serwerem", Toast.LENGTH_SHORT).show();
                }
            });
        });

        buttonBack.setOnClickListener(v -> finish());
    }
}
