package com.odhiambopaul.movie.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.odhiambopaul.movie.data.entity.Movie
import io.reactivex.Completable

@Dao
interface MovieDao {
    @Insert
    fun saveMovie(movie: Movie):Completable
}