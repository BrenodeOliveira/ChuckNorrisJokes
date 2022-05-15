package com.example.chucknorrisjokes.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorrisjokes.databinding.ActivityJokeBinding
import com.example.chucknorrisjokes.presentation.viewModel.JokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ROTATION_FLOAT = 360f
private const val DURATION_ANIMATION = 1800

internal class JokeActivity : AppCompatActivity() {

    private val binding: ActivityJokeBinding by lazy {
        ActivityJokeBinding.inflate(layoutInflater)
    }
    private val viewModel: JokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val categoryExtra = intent.getStringExtra("nameCategory").toString()

        binding.tvTitleCategory.text = categoryExtra

        viewModel.categoryString = categoryExtra

        initButtonGenerate()
    }

    private fun initButtonGenerate() {
        binding.btnGenerate.setOnClickListener {
            animateImage()
            generateJoke()
            observers()
        }
    }

    private fun observers() {
        viewModel.listJokeLiveData.observe(this) {
            binding.tvJokeText.text = viewModel.listJokeLiveData.value
        }
    }

    private fun generateJoke() {
        viewModel.generateJoke()
    }

    private fun animateImage() {
        binding.ivIoChuck.animate().apply {
            duration = DURATION_ANIMATION.toLong()
            rotationXBy(ROTATION_FLOAT)
            rotationYBy(ROTATION_FLOAT)
        }.start()
    }
}