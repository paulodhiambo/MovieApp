package com.odhiambopaul.movie.ui.home

import android.util.Log
import com.odhiambopaul.movie.data.response.MovieResponse
import com.odhiambopaul.movie.data.response.NowPlayingResponse
import com.odhiambopaul.movie.data.response.TopRatedResponse
import com.odhiambopaul.movie.data.response.UpcomingResponse
import com.odhiambopaul.movie.di.ui.BaseViewModel
import com.odhiambopaul.movie.repository.home.HomeRepository
import com.odhiambopaul.movie.util.api_key
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    fun getMovies(): Observable<MovieResponse> {
        return homeRepository.getPopularMovies(api_key)
    }

    fun getNowPlaying():Observable<NowPlayingResponse>
    {
        return homeRepository.getNowPlaying(api_key)
    }
    fun getTopRated():Observable<TopRatedResponse>
    {
        return homeRepository.getTopRated(api_key)
    }
    fun getUpComing():Observable<UpcomingResponse>
    {
        return homeRepository.getUpComing(api_key)
    }

    fun searchMovie(key: String, name: String) {
        compositeDisposable.add(
            homeRepository.searchMovie(key, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data -> Log.d("Success:::::", data.Poster) },
                    { t -> Log.e("Error::::", t.localizedMessage!!) })
        )
    }
}