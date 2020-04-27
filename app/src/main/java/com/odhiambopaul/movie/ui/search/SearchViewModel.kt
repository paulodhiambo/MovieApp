package com.odhiambopaul.movie.ui.search

import com.odhiambopaul.movie.data.entity.OmdbMovie
import com.odhiambopaul.movie.data.response.SearchResponse
import com.odhiambopaul.movie.di.ui.BaseViewModel
import com.odhiambopaul.movie.repository.home.HomeRepository
import io.reactivex.Observable
import javax.inject.Inject

class SearchViewModel @Inject constructor(val repository: HomeRepository):BaseViewModel()
{
    fun getSearchedMovie(key:String, search:String):Observable<OmdbMovie>
    {
        return repository.searchMovie(key,search)
    }
    fun getSearchResponse(key: String,search: String):Observable<SearchResponse>
    {
        return repository.getSearchMovie(key,search)
    }
}