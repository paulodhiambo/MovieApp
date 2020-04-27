package com.odhiambopaul.movie.service

import com.odhiambopaul.movie.data.entity.MovieDetail
import com.odhiambopaul.movie.data.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient{
    companion object{
        //movies
        const val NOW_PLAYING_MOVIES = "/3/movie/now_playing"
        const val POPULAR_MOVIES = "/3/movie/popular"
        const val TOP_RATED_MOVIES = "/3/movie/top_rated"
        const val UPCOMING_MOVIES = "/3/movie/upcoming"
        const val MOVIE_DETAILS ="/3/movie/{movie_id}"
        const val SIMILAR_MOVIES = "/3/movie/{movie_id}/similar"
        const val SEARCH_MOVIE ="3/search/movie"
    }
    @GET(SEARCH_MOVIE)
    fun getSearchMovie(@Query("api_key")key: String, @Query("query")search:String):Observable<SearchResponse>
    @GET(POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") key:String):Observable<MovieResponse>

    @GET(MOVIE_DETAILS)
    fun getMovieDetail(@Path("movie_id")id:String, @Query("api_key")key:String):Observable<MovieDetail>

    @GET(UPCOMING_MOVIES)
    fun getUpComingMovies(@Query("api_key")key:String):Observable<UpcomingResponse>

    @GET(TOP_RATED_MOVIES)
    fun getTopRatedMovies(@Query("api_key")key: String):Observable<TopRatedResponse>

    @GET(NOW_PLAYING_MOVIES)
    fun getNowPlayingMovies(@Query("api_key")key: String):Observable<NowPlayingResponse>

    @GET(SIMILAR_MOVIES)
    fun getSimilarMovies(@Path("movie_id")id:String,@Query("api_key")key: String):Observable<SimilarResponse>

}