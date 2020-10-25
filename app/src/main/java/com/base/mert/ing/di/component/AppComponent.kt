package com.base.mert.ing.di.component


import com.base.mert.ing.di.builder.ActivityBuilder
import com.base.mert.ing.di.builder.ViewModelBuilder
import com.base.mert.ing.di.module.AppModule
import com.base.mert.ing.di.module.RetrofitModule
import com.base.mert.ing.ui.application.BaseProjectApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class,
        ActivityBuilder::class,
        RetrofitModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseProjectApplication): Builder

        fun build(): AppComponent
    }

    fun inject(baseProjectApplication: BaseProjectApplication)
}