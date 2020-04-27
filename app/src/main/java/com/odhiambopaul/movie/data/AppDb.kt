package com.odhiambopaul.movie.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.odhiambopaul.movie.data.dao.MovieDao
import com.odhiambopaul.movie.data.entity.Movie


@Database(entities = [Movie::class], version = AppDb.VERSION, exportSchema = true)
abstract class AppDb : RoomDatabase(){
    companion object{
        const val VERSION = 1
    }
    abstract fun movieDao():MovieDao
}