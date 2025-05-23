package com.example.myhelpdeskapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class AuthRequest(val email: String, val password: String)
data class AuthResponse(val token: String)

interface ApiService {
    @POST("/api/register")
    fun register(@Body request: AuthRequest): Call<AuthResponse>

    @POST("/api/login")
    fun login(@Body request: AuthRequest): Call<AuthResponse>
}
