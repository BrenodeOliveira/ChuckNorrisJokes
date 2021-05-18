package com.example.chucknorrisjokes.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.ui.MainActivity
import com.example.chucknorrisjokes.viewModel.MainViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(Application()) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}