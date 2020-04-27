package com.odhiambopaul.movie.data.response

import com.odhiambopaul.movie.data.entity.Dates
import com.odhiambopaul.movie.data.entity.Movie

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int, // 1
    val results: List<Movie>,
    val total_pages: Int, // 44
    val total_results: Int // 861
)