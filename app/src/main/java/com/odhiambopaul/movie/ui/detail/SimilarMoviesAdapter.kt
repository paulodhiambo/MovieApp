package com.odhiambopaul.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.databinding.MovieItemBinding
import com.odhiambopaul.movie.util.image_path

class SimilarMoviesAdapter(private var movie: List<Movie>, val context: Context) :
    RecyclerView.Adapter<SimilarMoviesAdapter.SimilarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        val binding: MovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
        return SimilarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        holder.bind(movie[position])
        holder.itemView.setOnClickListener {
            val id = movie[position].id.toString()
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("poster", movie[position].poster_path)
            intent.putExtra("release_date", movie[position].release_date)
            intent.putExtra("language", movie[position].original_language)
            intent.putExtra("overview", movie[position].overview)
            intent.putExtra("title", movie[position].title)
            //clear the current activity
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    fun updateMovieList(movies: List<Movie>) {
        this.movie = movies
        notifyDataSetChanged()
    }

    class SimilarViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            Glide.with(itemView.context)
                .load("$image_path${movie.poster_path}")
                .into(binding.imageView)
        }
    }
}