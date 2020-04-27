package com.odhiambopaul.movie.service

import com.odhiambopaul.movie.data.entity.OmdbMovie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbClient {
    companion object{
        //
    }

    @GET("/")
    fun getSearchedMovie(@Query("apikey")key: String, @Query("t") name:String): Observable<OmdbMovie>
}