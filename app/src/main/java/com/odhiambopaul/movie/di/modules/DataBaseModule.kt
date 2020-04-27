package com.odhiambopaul.movie.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.data.AppDb
import com.odhiambopaul.movie.data.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(application: Application): AppDb {
        return Room.databaseBuilder(application,AppDb::class.java, "movie.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun providesMovieDao(appDb: AppDb):MovieDao {
        return appDb.movieDao()
    }
}