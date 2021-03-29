package com.example.bcads4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcads4.model.FilmModel
import com.example.bcads4.R

class AllMovieAdapter (
        private  var data: List<FilmModel>,
        private  val listener: (FilmModel) -> Unit
): RecyclerView.Adapter<AllMovieAdapter.MovieViewHolder>() {
    class MovieViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val ivPoster:ImageView = view.findViewById(R.id.iv_poster)
        private val tvTitle:TextView = view.findViewById(R.id.tv_title)
        private val tvDesc:TextView = view.findViewById(R.id.tv_desc)
        private val rbMovie:RatingBar = view.findViewById(R.id.ratingBar)

        fun bindItem(data: FilmModel, listener: (FilmModel) -> Unit, context: Context, position: Int) {
            tvTitle.text = data.title
            tvDesc.text = data.desc
            rbMovie.rating = data.rating
            Glide.with(context)
                .load(data.poster)
                .into(ivPoster)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflateView : View = layoutInflater.inflate(R.layout.item_movie_vertical, parent, false)
        return MovieViewHolder(inflateView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size


}