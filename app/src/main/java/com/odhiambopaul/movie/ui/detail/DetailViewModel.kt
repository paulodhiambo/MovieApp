package com.odhiambopaul.movie.ui.detail

import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.data.entity.MovieDetail
import com.odhiambopaul.movie.data.response.SimilarResponse
import com.odhiambopaul.movie.di.ui.BaseViewModel
import com.odhiambopaul.movie.repository.detail.DetailRepository
import io.reactivex.Observable
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : BaseViewModel() {

    fun getMovi(id: String, key: String): Observable<MovieDetail> {
        return detailRepository.getMovieById(id, key)
    }

    fun getSimilarMovies(id: String, key: String): Observable<SimilarResponse> {
        return detailRepository.getSimilarMovies(id, key)
    }


}