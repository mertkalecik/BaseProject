package com.base.mert.baseproject.di.component

import com.base.mert.baseproject.di.builder.ActivityBuilder
import com.base.mert.baseproject.di.builder.ViewModelBuilder
import com.base.mert.baseproject.di.module.AppModule
import com.base.mert.baseproject.ui.application.BaseProjectApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
                      AndroidInjectionModule::class,
                      AndroidSupportInjectionModule::class,
                      ViewModelBuilder::class,
                      ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseProjectApplication): Builder

        fun build(): AppComponent
    }

    fun inject(baseProjectApplication: BaseProjectApplication)

}