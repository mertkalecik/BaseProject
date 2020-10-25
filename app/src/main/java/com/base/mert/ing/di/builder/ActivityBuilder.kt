package com.base.mert.ing.di.builder

import com.base.mert.ing.di.provider.HomeFragmentProvider
import com.base.mert.ing.di.provider.LoginIdPassFragmentProvider
import com.base.mert.ing.di.provider.MapFragmentProvider
import com.base.mert.ing.ui.activity.LoginActivity
import com.base.mert.ing.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
    LoginIdPassFragmentProvider::class])
    abstract fun provideLoginActivity(): LoginActivity


    @ContributesAndroidInjector(modules = [
    HomeFragmentProvider::class,
    MapFragmentProvider::class])
    abstract fun provideMainActivity(): MainActivity
}