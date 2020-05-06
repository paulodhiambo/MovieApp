package com.odhiambopaul.movie.ui.adapter

import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.databinding.MovieItemBinding
import com.odhiambopaul.movie.di.ui.BaseRecyclerViewAdapter

class SimilarMoviesAdapter : BaseRecyclerViewAdapter<Movie, MovieItemBinding>() {
    override fun getLayout(): Int {
        return R.layout.movie_item
    }

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<MovieItemBinding>,
        position: Int
    ) {
        holder.binding.movie = items[position]
        //onclick event
        holder.binding.root.setOnClickListener {
            listener?.invoke(it, items[position], position)
        }
    }

}