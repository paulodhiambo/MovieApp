package com.odhiambopaul.movie.di.component

import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.di.modules.ApiModule
import com.odhiambopaul.movie.di.modules.DataBaseModule
import com.odhiambopaul.movie.di.modules.ViewModelModule
import com.odhiambopaul.movie.ui.detail.DetailActivity
import com.odhiambopaul.movie.ui.home.HomeActivity
import com.odhiambopaul.movie.ui.search.SearchActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * You’ve told Dagger that AppComponent is a singleton component interface for the app.
 * The @Component annotation takes a list of modules as an input. You’re using the literal array syntax
 * available in Kotlin, [ApplicationModule::class].
 *
 * The component is used to connect objects to their dependencies, typically by use of overridden inject() methods.
 * In order to use the component, it must be accessible from the parts of the app that need injection.
 *
 * Components are essentially the glue that holds everything together. They are a way of telling Dagger 2
 * what dependencies should be bundled together and made available to a given instance so they can be used.
 *
 * A Component in Dagger2 is something which provides(or supplies) dependencies to injection target(i.e. the object which need dependencies).
 * Components are interfaces between Module and Injection Target.
 *
 * @modules: modules which provide dependencies to AppComponent
 * Modules are classes which do actual work of instantiating dependencies or creating actual objects which Component will supply to Injection Targets.
 * One is ApiModule which provides Retrofit instance for networking other is AppModule which provides other global objects like Application and Database and many more
 *
 */

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, ViewModelModule::class, ApiModule::class, DataBaseModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {
    //activity and fragment injections
    fun inject(homeActivity: HomeActivity)

    fun inject(searchActivity: SearchActivity)

    fun inject(detailActivity: DetailActivity)
    /**
     *
     * The @Component.Factory
     * The recent Dagger 2.22 introduced an alternative to the component (or subcomponent again) builder, which is the component factory.
     * A factory here is basically a more versatile (and less verbose!) builder. Instead of annotating individual methods,
     * the factory has only one single method and we can annotate its parameters.
     * This is definitely less verbose and it looks quite nice. And the most important point that I originally missed here is that this change brings compile time safety
     *
     */

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

}