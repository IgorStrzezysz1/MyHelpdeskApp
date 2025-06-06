package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private Button buttonAktywneZgloszenie;
    private Button buttonAchivalTickets;
    private Button buttonBack;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonAktywneZgloszenie = findViewById(R.id.buttonAktywneZgloszenie);
        buttonAchivalTickets = findViewById(R.id.buttonAchivalTickets);
        buttonBack = findViewById(R.id.buttonBack);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAktywneZgloszenie.setOnClickListener(v ->
                Toast.makeText(this, "Kliknięto Aktywne zgłoszenia", Toast.LENGTH_SHORT).show()
        );

        buttonAchivalTickets.setOnClickListener(v ->
                Toast.makeText(this, "Kliknięto Archiwalne zgłoszenia", Toast.LENGTH_SHORT).show()
        );

        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


        buttonAktywneZgloszenie.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, ActiveTicketsActivity.class);
            startActivity(intent);
        });

        Button buttonArchivalTickets = findViewById(R.id.buttonAchivalTickets);
                buttonArchivalTickets.setOnClickListener(v ->{
                    Intent intent=new Intent(MainMenuActivity.this, ArchivalTicketsActivity.class);
                    startActivity(intent);
                });

    }
}
