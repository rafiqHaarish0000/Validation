package com.example.screenorientation.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.screenorientation.R

class CustomAdapter(private val data: ArrayList<ItemViewModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel: ItemViewModel = data[position]
        holder.author.text = viewModel.author
        holder.name.text = viewModel.name
        holder.description.text = viewModel.description
        holder.stars.text = viewModel.stars
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val author = itemView.findViewById(R.id.author) as TextView
        val name = itemView.findViewById(R.id.url) as TextView
        val description = itemView.findViewById(R.id.description) as TextView
        val stars = itemView.findViewById(R.id.stars) as TextView
    }
}