package com.base.mert.ing.di.provider

import com.base.mert.ing.di.module.HomeFragmentModule
import com.base.mert.ing.ui.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentProvider {
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}