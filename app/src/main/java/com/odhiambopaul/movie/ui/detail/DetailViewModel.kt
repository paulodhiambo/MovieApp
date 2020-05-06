package com.odhiambopaul.movie.ui.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.data.entity.MovieDetail
import com.odhiambopaul.movie.data.response.SimilarResponse
import com.odhiambopaul.movie.di.ui.BaseViewModel
import com.odhiambopaul.movie.repository.detail.DetailRepository
import com.odhiambopaul.movie.util.api_key
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : BaseViewModel() {
    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovie: LiveData<List<Movie>>
        get() = _similarMovies

    @SuppressLint("LogNotTimber")
    fun similarMovies(id: String) {
        compositeDisposable.add(
            detailRepository.getSimilarMovies(id, api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val movieResponse = it.results
                    _similarMovies.value = movieResponse
                }, {
                    Log.e("Error:::", it.localizedMessage!!)
                })
        )
    }
}