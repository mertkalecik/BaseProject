package com.base.mert.baseproject.di.provider

import com.base.mert.baseproject.di.module.PersonFragmentModule
import com.base.mert.baseproject.ui.fragment.PersonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PersonFragmentProvider {

    @ContributesAndroidInjector(modules = [PersonFragmentModule::class])
    abstract fun providePersonFragment(): PersonFragment
}