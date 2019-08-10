package com.base.mert.baseproject.di.builder

import com.base.mert.baseproject.di.provider.HomeFragmentProvider
import com.base.mert.baseproject.di.provider.LoginIdPassFragmentProvider
import com.base.mert.baseproject.di.provider.MapFragmentProvider
import com.base.mert.baseproject.di.provider.PersonFragmentProvider
import com.base.mert.baseproject.ui.activity.LoginActivity
import com.base.mert.baseproject.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [
    LoginIdPassFragmentProvider::class])
    abstract fun provideLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [
    HomeFragmentProvider::class,
    MapFragmentProvider::class,
    PersonFragmentProvider::class])
    abstract fun provideMainActivity(): MainActivity
}