package com.example.chucknorrisjokes.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val listCategoriesLiveData: MutableLiveData<List<String>> = MutableLiveData()

    fun fillRecycler() {
        ApiService.categoryService.fetchAllCategory().enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    val fillingRv = response.body()
                    listCategoriesLiveData.value = fillingRv
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("Breno", "Falha")
            }

        })
    }
}