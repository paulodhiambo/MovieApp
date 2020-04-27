package com.odhiambopaul.movie.di.modules

import android.content.Context
import com.odhiambopaul.movie.util.annotations.ApplicationScope
import com.odhiambopaul.movie.util.annotations.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides


@Module
class ContextModule(private val context: Context) {
    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }

}