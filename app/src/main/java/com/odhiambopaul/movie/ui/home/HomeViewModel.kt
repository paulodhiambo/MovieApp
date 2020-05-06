package com.odhiambopaul.movie.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.odhiambopaul.movie.data.entity.Movie
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
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies
    private var homeListener: MovieListener? = null

    fun getMovie() {
        compositeDisposable.add(
            homeRepository.getPopularMovies(api_key)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { homeListener?.onFetchStarted() }
                .doOnTerminate { homeListener?.onFetchFinished() }
                .doOnComplete { homeListener?.onFetchFinished() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movie ->
                    homeRepository.getNowPlaying(api_key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            val movieResponse = movie.results + it.results
                            _movies.value = movieResponse
                        }, {
                            homeListener?.onFailure(it.localizedMessage!!)
                        })
                }, {
                    homeListener?.onFailure(it.localizedMessage!!)
                })
        )
    }
}