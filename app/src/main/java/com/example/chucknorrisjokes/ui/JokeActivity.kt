package com.example.chucknorrisjokes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.viewModel.JokeViewModel
import com.example.chucknorrisjokes.viewModel.factory.JokeViewModelFactory
import kotlinx.android.synthetic.main.activity_joke.*

class JokeActivity : AppCompatActivity() {

    private lateinit var viewModel: JokeViewModel
    private val viewModelFactory = JokeViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        val categoryExtra = intent.getStringExtra("nameCategory").toString()

        tv_title_category.text = categoryExtra

        viewModel = ViewModelProvider(this, viewModelFactory).get(JokeViewModel::class.java)
        viewModel.categoryString = categoryExtra

        initButtonGenerate()
    }

    private fun initButtonGenerate() {
        btn_generate.setOnClickListener {
            animateImage()
            generateJoke()
            observers()
        }
    }

    private fun observers() {
        viewModel.listJokeLiveData.observe(this, {
            tv_joke_text.text = viewModel.listJokeLiveData.value
        })
    }

    private fun generateJoke() {
        viewModel.genereteJoke()
    }

    private fun animateImage() {
        iv_io_chuck.animate().apply {
            duration = 1500
            rotationXBy(360f)
            rotationYBy(360f)
        }.start()
    }
}