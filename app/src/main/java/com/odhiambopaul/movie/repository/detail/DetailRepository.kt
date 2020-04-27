package com.odhiambopaul.movie.repository.detail

import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.data.entity.MovieDetail
import com.odhiambopaul.movie.data.response.SimilarResponse
import com.odhiambopaul.movie.service.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class DetailRepository @Inject constructor(val service: ApiService){

    fun getMovieById(id:String,key:String): Observable<MovieDetail>
    {
        return service.getMovieDetail(id,key)
    }

    fun getSimilarMovies(id: String, key: String):Observable<SimilarResponse>
    {
        return service.getSimilarMovies(id,key)
    }
}