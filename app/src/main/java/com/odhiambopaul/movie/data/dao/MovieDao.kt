package com.odhiambopaul.movie.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.odhiambopaul.movie.data.entity.Movie
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieDao {
    @Insert
    fun saveMovie(movie: Movie):Completable

    @Query("SELECT * FROM Movie")
    fun getMovies():Flowable<List<Movie>>
}