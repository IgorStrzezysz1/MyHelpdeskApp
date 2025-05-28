package com.example.myhelpdeskapp
import android.provider.ContactsContract.CommonDataKinds.Email
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/register")
    fun registerUser(@Body user: User): Call<Void>
    @POST("/api/v1/login")
    fun login(@Header("X-Auth-Email")
              email: String,@Header("X-Auth-Password")password: String): Call<AuthResponse>
}
