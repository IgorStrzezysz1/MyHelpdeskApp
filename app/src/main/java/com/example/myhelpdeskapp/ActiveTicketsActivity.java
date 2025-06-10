package com.example.myhelpdeskapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActiveTicketsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TicketAdapter adapter;
    private List<Ticket> ticketList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_tickets);

        recyclerView = findViewById(R.id.recyclerViewTickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TicketAdapter(this, ticketList);
        recyclerView.setAdapter(adapter);

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(ActiveTicketsActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        });

        Button addButton = findViewById(R.id.buttonAddTicket);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActiveTicketsActivity.this, AddTicketActivity.class);
            startActivity(intent);
        });

        loadTickets();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTickets();
    }

    private void loadTickets() {
        RetrofitClient.getApiService().getActiveTickets().enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                Log.d("RESPONSE", "code: " + response.code());

                if (response.body() != null) {
                    Log.d("RESPONSE", "tickets: " + new Gson().toJson(response.body()));
                    ticketList.clear();
                    ticketList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    try {
                        Log.e("RESPONSE", "errorBody: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {
                Log.e("RESPONSE", "failure", t);
            }
        });
    }
}

