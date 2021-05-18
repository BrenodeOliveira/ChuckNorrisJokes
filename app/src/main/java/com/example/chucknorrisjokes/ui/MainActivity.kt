package com.example.chucknorrisjokes.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.adapter.CategoryAdapter
import com.example.chucknorrisjokes.interfaces.OnClickRecycler
import com.example.chucknorrisjokes.viewModel.MainViewModel
import com.example.chucknorrisjokes.viewModel.factory.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_row.*

class MainActivity : AppCompatActivity(), OnClickRecycler {

    private lateinit var viewModel: MainViewModel
    private val viewModelFactory = MainViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializa ViewModel instanciando o factory
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //Chama o metodo de preencher o recycler
        viewModel.fillRecycler()

        //Instancia os observers
        observers()
    }

    private fun observers() {
        viewModel.listCategoriesLiveData.observe(this, {
            it?.let { nameCate ->
                rv_menu_jokes.apply {
                    adapter = CategoryAdapter(nameCate, this@MainActivity)
                }
            }
        })
    }

    override fun onItemClicked(position: Int) {
        var categoryToFilter = ""

        viewModel.listCategoriesLiveData.observe(this, {
            categoryToFilter = it.elementAt(position).toString()
        })

        val intent = Intent(this, JokeActivity::class.java)
        intent.putExtra("nameCategory", categoryToFilter)

        startActivity(intent)
    }

}