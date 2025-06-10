package com.example.myhelpdeskapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @PUT("tickets/{id}")
    fun updateTicket(
        @Path("id") id: Long,
        @Body ticket: Ticket
    ): Call<Ticket>

    @GET("tickets/archival")
    fun getArchivalTickets(): Call<List<Ticket>>

    @GET("tickets/active")
    fun getActiveTickets(): Call<List<Ticket>>

    @POST("tickets")
    fun addTicket(@Body ticket: Ticket): Call<Ticket>

    @POST("register")
    fun registerUser(@Body user: User): Call<Void>

    @POST("login")
    fun login(
        @Header("X-Auth-Email") email: String,
        @Header("X-Auth-Password") password: String
    ): Call<AuthResponse>
}
