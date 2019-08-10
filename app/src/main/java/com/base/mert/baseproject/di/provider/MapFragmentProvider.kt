package com.base.mert.baseproject.di.provider

import com.base.mert.baseproject.di.module.MapFragmentModule
import com.base.mert.baseproject.ui.fragment.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MapFragmentProvider {

    @ContributesAndroidInjector(modules = [MapFragmentModule::class])
    abstract fun provideMapFragment(): MapFragment
}