package com.odhiambopaul.movie.di.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseViewModel :ViewModel(){
    val compositeDisposable  = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}