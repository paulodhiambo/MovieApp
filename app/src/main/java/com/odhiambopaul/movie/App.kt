package com.odhiambopaul.movie

import android.app.Activity
import android.app.Application
import com.odhiambopaul.movie.di.component.ApplicationComponent
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: App
        @JvmStatic
        fun getInstance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        configureDagger()
        instance = this
    }

    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    private fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }


}