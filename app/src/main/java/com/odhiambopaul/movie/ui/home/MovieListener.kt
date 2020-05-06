package com.odhiambopaul.movie.ui.home

interface MovieListener {
    fun onFetchStarted()
    fun onFetchFinished()
    fun onFailure(message: String)
}