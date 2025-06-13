package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    private Button buttonAktywneZgloszenie;
    private Button buttonAchivalTickets;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonAktywneZgloszenie = findViewById(R.id.buttonAktywneZgloszenie);
        buttonAchivalTickets = findViewById(R.id.buttonAchivalTickets);
        buttonBack = findViewById(R.id.buttonBack);

        buttonAktywneZgloszenie.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, ActiveTicketsActivity.class);
            startActivity(intent);
        });

        buttonAchivalTickets.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, ArchivalTicketsActivity.class);
            startActivity(intent);
        });

        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
