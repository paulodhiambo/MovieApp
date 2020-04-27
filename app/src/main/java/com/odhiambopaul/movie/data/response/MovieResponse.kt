package com.odhiambopaul.movie.data.response

import com.odhiambopaul.movie.data.entity.Movie

data class MovieResponse(
    val page: Int, // 1
    val results: List<Movie>,
    val total_pages: Int, // 500
    val total_results: Int // 10000
)