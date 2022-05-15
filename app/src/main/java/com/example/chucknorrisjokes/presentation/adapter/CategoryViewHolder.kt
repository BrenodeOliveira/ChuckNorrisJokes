package com.example.chucknorrisjokes.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokes.databinding.CategoryRowBinding

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: CategoryRowBinding = CategoryRowBinding.bind(view)

    fun bind(nameCategory: String) {
        binding.titleCategory.text = nameCategory
    }
}