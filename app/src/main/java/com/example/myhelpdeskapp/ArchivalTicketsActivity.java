package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArchivalTicketsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Ticket> archivalTickets;
    private TicketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archival_tickets);

        recyclerView = findViewById(R.id.recyclerViewTickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        archivalTickets = new ArrayList<>();
        adapter = new TicketAdapter(this, archivalTickets);
        recyclerView.setAdapter(adapter);

        Button back = findViewById(R.id.buttonBack);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(ArchivalTicketsActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        });

        loadArchivalTickets();
    }

    private void loadArchivalTickets() {
        RetrofitClient.getApiService().getArchivalTickets().enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    archivalTickets.clear();
                    archivalTickets.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
