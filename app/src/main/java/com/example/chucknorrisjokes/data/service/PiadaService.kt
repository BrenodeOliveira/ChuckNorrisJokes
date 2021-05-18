package com.example.chucknorrisjokes.data.service

import com.example.chucknorrisjokes.data.model.Piada
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PiadaService {

    @GET("random")
    fun callPiada(@Query("category") category: String) : Call<Piada>
}