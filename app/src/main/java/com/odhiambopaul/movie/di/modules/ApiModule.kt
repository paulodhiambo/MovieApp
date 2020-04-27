package com.odhiambopaul.movie.di.modules

import com.odhiambopaul.movie.BuildConfig
import com.odhiambopaul.movie.util.BASE_URL
import com.odhiambopaul.movie.util.BASE_URL_OMDB
import com.odhiambopaul.movie.util.annotations.Omdb
import com.odhiambopaul.movie.util.annotations.Tmdb
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApiModule{
    //using annotations to distinguish between various base urls
    @Provides
    @Singleton
    @Tmdb
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createClient()!!)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    @Omdb
    fun provideRetrofit2():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_OMDB)
            .client(createClient()!!)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient? {
        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor: HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        //okHttpClientBuilder.addInterceptor(CustomInterceptor())
        return okHttpClientBuilder.build()
    }


}