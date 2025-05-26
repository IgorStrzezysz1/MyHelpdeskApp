package com.example.myhelpdeskapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/register")
    fun registerUser(@Body user: User): Call<Void>
}
