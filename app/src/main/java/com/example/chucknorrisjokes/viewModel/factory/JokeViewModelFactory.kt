package com.example.chucknorrisjokes.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.viewModel.JokeViewModel

@Suppress("UNCHECKED_CAST")
class JokeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokeViewModel::class.java)) {
            return JokeViewModel(Application()) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}