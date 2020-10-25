package com.base.mert.ing.di.provider

import com.base.mert.ing.di.module.MapFragmentModule
import com.base.mert.ing.ui.fragment.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MapFragmentProvider {

    @ContributesAndroidInjector(modules = [MapFragmentModule::class])
    abstract fun provideMapFragment(): DetailFragment
}