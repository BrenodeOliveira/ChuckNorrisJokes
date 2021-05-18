package com.example.chucknorrisjokes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.interfaces.OnClickRecycler
import com.example.chucknorrisjokes.ui.MainActivity
import kotlinx.android.synthetic.main.category_row.view.*

class CategoryAdapter(
    private val category: List<String>,
    private val listener: OnClickRecycler
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(category[position])

        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int = category.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val name = view.title_category

        fun bindView(nameCategory: String) {
            name.text = nameCategory
        }
    }
}