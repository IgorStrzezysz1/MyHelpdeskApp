package com.example.myhelpdeskapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private Context context;
    private List<Ticket> ticketList;

    public TicketAdapter(Context context, List<Ticket> ticketList) {
        this.context = context;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = ticketList.get(position);
        holder.title.setText(ticket.getTitle());
        holder.description.setText(ticket.getDescription());

        holder.buttonEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditTicketActivity.class);
            intent.putExtra("title", ticket.getTitle());
            intent.putExtra("description", ticket.getDescription());
            intent.putExtra("ticketId", ticket.getId());
            context.startActivity(intent);
        });

        holder.buttonDelete.setOnClickListener(v -> {
            Ticket archivedTicket = ticketList.get(holder.getAdapterPosition());
            archivedTicket.setStatus("archived");

            RetrofitClient.getApiService().updateTicket(archivedTicket.getId(), archivedTicket)
                    .enqueue(new Callback<Ticket>() {
                        @Override
                        public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                            if (response.isSuccessful()) {
                                int pos = holder.getAdapterPosition();
                                ticketList.remove(pos);
                                notifyItemRemoved(pos);
                                Toast.makeText(context, "Zarchiwizowano ticket", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Błąd archiwizacji", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Ticket> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(context, "Błąd sieci", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public static class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        Button buttonEdit, buttonDelete;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            description = itemView.findViewById(R.id.textViewDescription);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
