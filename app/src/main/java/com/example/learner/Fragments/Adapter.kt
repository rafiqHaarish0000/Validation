package com.example.learner.Fragments

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learner.R
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class Adapter(private var data: ArrayList<TrendingRepo>, private val context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_handler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: TrendingRepo = data[position]
        val gradientDrawable: GradientDrawable = GradientDrawable()
        val randomColor: Random = Random()
        val payLoads: List<Any>
        val colour: Int


        randomColor.let {
            colour = Color.argb(
                255, randomColor.nextInt(255),
                randomColor.nextInt(256), randomColor.nextInt(256)
            )
        }

        gradientDrawable.apply {
            gradientDrawable.shape = GradientDrawable.OVAL
            gradientDrawable.setColor(colour)
        }

        holder.author.text = item.author
        holder.name.text = item.name
        holder.description.text = item.description
        holder.stars.text = item.stars
        holder.language.text = item.language
        holder.language_color.setImageDrawable(gradientDrawable)

        Picasso.get()
            .load(item.avatar)
            .resize(50, 50)
            .centerCrop()
            .into(holder.avatar)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //set position
    fun updateDataset(it: ArrayList<TrendingRepo>) {
        val lastPosition = this.data.size
        this.data.addAll(it)
        notifyItemChanged(lastPosition)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val author = itemView.findViewById(R.id.author) as TextView
        val name = itemView.findViewById(R.id.url) as TextView
        val description = itemView.findViewById(R.id.description) as TextView
        val stars = itemView.findViewById(R.id.stars) as TextView
        val language = itemView.findViewById(R.id.language) as TextView
        val avatar = itemView.findViewById(R.id.avatar) as ImageView
        val language_color = itemView.findViewById(R.id.language_color) as ImageView
    }

    fun resetview(filterData: List<TrendingRepo>) {
        this.data = filterData as ArrayList<TrendingRepo>
        notifyDataSetChanged()
    }

}
