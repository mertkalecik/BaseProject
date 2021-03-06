package com.base.mert.baseproject.di.module

import android.app.Application
import com.base.mert.baseproject.ui.application.BaseProjectApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(application: BaseProjectApplication): Application {
        return application
    }
}