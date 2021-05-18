package com.example.chucknorrisjokes.data.retrofit

import com.example.chucknorrisjokes.constants.Constants
import com.example.chucknorrisjokes.data.service.CategoryService
import com.example.chucknorrisjokes.data.service.PiadaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val categoryService: CategoryService = initRetrofit().create(CategoryService::class.java)
    val piadaService: PiadaService = initRetrofit().create(PiadaService::class.java)
}