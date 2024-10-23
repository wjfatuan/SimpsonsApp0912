package com.example.simpsonsapp0912.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CatsApi {

    @GET("v1/images/search")
    suspend fun search(): List<Cat>

    companion object {
        fun getInstance(): CatsApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CatsApi::class.java)
        }
    }

}