package com.example.chucknorrisjokes.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.data.model.Piada
import com.example.chucknorrisjokes.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel : ViewModel() {

    val listJokeLiveData: MutableLiveData<String> = MutableLiveData()
    lateinit var categoryString: String

    fun generateJoke() {
        ApiService.piadaService.callPiada(categoryString).enqueue(object : Callback<Piada> {
            override fun onResponse(call: Call<Piada>, response: Response<Piada>) {
                var textPiada: String? = ""

                if (response.isSuccessful) {
                    textPiada = response.body()?.value.toString()
                }

                listJokeLiveData.value = textPiada
            }

            override fun onFailure(call: Call<Piada>, t: Throwable) {
                Log.d("Breno", "Falha")
            }

        })
    }

}