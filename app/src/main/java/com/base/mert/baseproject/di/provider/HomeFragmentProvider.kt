package com.base.mert.baseproject.di.provider

import com.base.mert.baseproject.di.module.HomeFragmentModule
import com.base.mert.baseproject.ui.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}