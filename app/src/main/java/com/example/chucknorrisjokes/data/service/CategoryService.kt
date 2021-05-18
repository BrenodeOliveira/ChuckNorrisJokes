package com.example.chucknorrisjokes.data.service

import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {
    @GET("categories/")
    fun fetchAllCategory(): Call<List<String>>
}