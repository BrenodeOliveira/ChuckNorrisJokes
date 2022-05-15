package com.example.chucknorrisjokes.di

import com.example.chucknorrisjokes.presentation.viewModel.JokeViewModel
import com.example.chucknorrisjokes.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        JokeViewModel()
    }

    viewModel {
        MainViewModel()
    }
}