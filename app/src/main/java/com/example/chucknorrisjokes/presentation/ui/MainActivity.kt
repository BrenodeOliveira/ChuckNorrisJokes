package com.example.chucknorrisjokes.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chucknorrisjokes.presentation.adapter.CategoryAdapter
import com.example.chucknorrisjokes.databinding.ActivityMainBinding
import com.example.chucknorrisjokes.interfaces.OnClickRecycler
import com.example.chucknorrisjokes.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), OnClickRecycler {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.fillRecycler()

        observers()
    }

    private fun observers() {
        viewModel.listCategoriesLiveData.observe(this) {
            it?.let { nameCate ->
                binding.rvMenuJokes.apply {
                    adapter = CategoryAdapter(nameCate, this@MainActivity)
                }
            }
        }
    }

    override fun onItemClicked(position: Int) {
        var categoryToFilter = ""

        viewModel.listCategoriesLiveData.observe(this) {
            categoryToFilter = it.elementAt(position).toString()
        }

        val intent = Intent(this, JokeActivity::class.java)
        intent.putExtra("nameCategory", categoryToFilter)

        startActivity(intent)
    }

}