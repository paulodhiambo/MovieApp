package com.odhiambopaul.movie.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.odhiambopaul.movie.di.ViewModelFactory
import com.odhiambopaul.movie.di.key.ViewModelKey
import com.odhiambopaul.movie.ui.detail.DetailViewModel
import com.odhiambopaul.movie.ui.home.HomeViewModel
import com.odhiambopaul.movie.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    /**
     *
     * Multibinding: https://blog.kotlin-academy.com/understanding-dagger-2-multibindings-viewmodel-8418eb372848
     *
     */
    @Binds
    internal abstract fun bindViewModelFactory(factory:ViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel):ViewModel

}