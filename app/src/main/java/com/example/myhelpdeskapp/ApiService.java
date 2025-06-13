package com.example.myhelpdeskapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @PUT("tickets/{id}")
    Call<Ticket> updateTicket(@Path("id") long id, @Body Ticket ticket);

    @GET("tickets/archival")
    Call<List<Ticket>> getArchivalTickets();

    @GET("tickets/active")
    Call<List<Ticket>> getActiveTickets();

    @POST("tickets")
    Call<Ticket> addTicket(@Body Ticket ticket);

    @POST("register")
    Call<Void> registerUser(@Body User user);

    @POST("login")
    Call<AuthResponse> login(
            @Header("X-Auth-Email") String email,
            @Header("X-Auth-Password") String password
    );
}
