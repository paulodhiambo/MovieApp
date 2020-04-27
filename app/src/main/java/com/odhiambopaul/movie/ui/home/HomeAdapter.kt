package com.odhiambopaul.movie.ui.home

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.databinding.MovieItemBinding
import com.odhiambopaul.movie.ui.detail.DetailActivity
import com.odhiambopaul.movie.util.image_path

class HomeAdapter(private var movie: List<Movie>, val context: Context) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding: MovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                context.startActivity(intent)
                Toast.makeText(context, Build.VERSION.BASE_OS, Toast.LENGTH_LONG).show()

            }
            else{
                context.startActivity(intent)
            }

            //Toast.makeText(context, id, Toast.LENGTH_LONG).show()
        }
    }

    fun updateMovieList(movies: List<Movie>) {
        this.movie = movies
        notifyDataSetChanged()
    }

    class HomeViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            Glide.with(itemView.context)
                .load("$image_path${movie.poster_path}")
                .into(binding.imageView)
        }
    }
}