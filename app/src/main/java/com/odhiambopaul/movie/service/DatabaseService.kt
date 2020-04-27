package com.odhiambopaul.movie.service

import com.odhiambopaul.movie.data.dao.MovieDao
import com.odhiambopaul.movie.data.entity.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class DatabaseService @Inject constructor(private val movieDao: MovieDao){

    fun saveMovies(movie: Movie):Completable
    {
        return movieDao.saveMovie(movie)
    }

    fun getMovies():Flowable<List<Movie>>
    {
        return movieDao.getMovies()
    }
}