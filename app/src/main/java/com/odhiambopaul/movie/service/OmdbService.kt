package com.odhiambopaul.movie.service

import com.odhiambopaul.movie.data.entity.OmdbMovie
import com.odhiambopaul.movie.util.annotations.Omdb
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OmdbService @Inject constructor(@Omdb retrofit:Retrofit):OmdbClient{
    private val api by lazy {
        retrofit.create(OmdbClient::class.java)
    }

    override fun getSearchedMovie(key: String, name: String): Observable<OmdbMovie> {
        return api.getSearchedMovie(key,name)
    }
}