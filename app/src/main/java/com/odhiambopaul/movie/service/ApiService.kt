package com.odhiambopaul.movie.service

import com.odhiambopaul.movie.data.entity.MovieDetail
import com.odhiambopaul.movie.data.response.*
import com.odhiambopaul.movie.util.annotations.Tmdb
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(@Tmdb retrofit: Retrofit):ApiClient{
    private val api by lazy {
        retrofit.create(ApiClient::class.java)
    }

    override fun getSearchMovie(key: String, search: String):Observable<SearchResponse> {
        return api.getSearchMovie(key,search)
    }

    override fun getPopularMovies(key: String): Observable<MovieResponse> {
        return api.getPopularMovies(key)
    }

    override fun getMovieDetail(id: String, key: String): Observable<MovieDetail> {
        return api.getMovieDetail(id,key)
    }

    override fun getUpComingMovies(key: String): Observable<UpcomingResponse> {
        return api.getUpComingMovies(key)
    }

    override fun getTopRatedMovies(key: String): Observable<TopRatedResponse> {
        return api.getTopRatedMovies(key)
    }

    override fun getNowPlayingMovies(key: String): Observable<NowPlayingResponse> {
        return api.getNowPlayingMovies(key)
    }

    override fun getSimilarMovies(id: String, key: String): Observable<SimilarResponse> {
        return api.getSimilarMovies(id,key)
    }

}