package com.odhiambopaul.movie.repository.home

import com.odhiambopaul.movie.data.entity.OmdbMovie
import com.odhiambopaul.movie.data.response.*
import com.odhiambopaul.movie.service.ApiService
import com.odhiambopaul.movie.service.OmdbService
import io.reactivex.Observable
import javax.inject.Inject

class HomeRepository @Inject constructor(private val service: ApiService, private val omdbService: OmdbService)
{
    fun getPopularMovies(key:String):Observable<MovieResponse>
    {
        return service.getPopularMovies(key)
    }
    fun getSearchMovie(key: String, search:String):Observable<SearchResponse>
    {
        return service.getSearchMovie(key,search)
    }

    fun searchMovie(key: String, name:String):Observable<OmdbMovie>
    {
        return omdbService.getSearchedMovie(key, name)
    }
    fun getNowPlaying(key: String):Observable<NowPlayingResponse>
    {
        return service.getNowPlayingMovies(key)
    }
    fun getTopRated(key: String):Observable<TopRatedResponse>
    {
        return service.getTopRatedMovies(key)
    }
    fun getUpComing(key: String):Observable<UpcomingResponse>
    {
        return service.getUpComingMovies(key)
    }
}