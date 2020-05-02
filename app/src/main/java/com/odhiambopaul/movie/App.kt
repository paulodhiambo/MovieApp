package com.odhiambopaul.movie

import android.app.Activity
import android.app.Application
import com.odhiambopaul.movie.di.component.ApplicationComponent
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import timber.log.Timber
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
        initTimber()
        instance = this
    }

    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    private fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
    }


}