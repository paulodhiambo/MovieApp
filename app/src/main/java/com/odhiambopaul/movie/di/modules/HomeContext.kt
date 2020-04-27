package com.odhiambopaul.movie.di.modules

import android.content.Context
import com.odhiambopaul.movie.ui.home.HomeActivity
import com.odhiambopaul.movie.util.annotations.ActivityScope
import com.odhiambopaul.movie.util.annotations.qualifier.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class MainActivityContextModule(private val mainActivity: HomeActivity) {
    var context: Context = mainActivity
    @Provides
    @ActivityScope
    fun providesHomeActivity(): HomeActivity {
        return mainActivity
    }

    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

}