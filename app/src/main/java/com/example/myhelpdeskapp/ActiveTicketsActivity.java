package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActiveTicketsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TicketAdapter adapter;
    private List<Ticket> ticketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_tickets);

        recyclerView = findViewById(R.id.recyclerViewTickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ticketList = new ArrayList<>();
        ticketList.add(new Ticket("Zgłoszenie 1", "Opis testowy"));
        ticketList.add(new Ticket("Zgłoszenie 2", "Inny opis"));

        adapter = new TicketAdapter(this, ticketList);
        recyclerView.setAdapter(adapter);

        // Obsługa przycisku "Powrót"
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(ActiveTicketsActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
