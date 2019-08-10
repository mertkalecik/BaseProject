package com.base.mert.baseproject.di.provider

import com.base.mert.baseproject.di.module.LoginIdPassFragmentModule
import com.base.mert.baseproject.ui.fragment.LoginIdPassFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginIdPassFragmentProvider {

    @ContributesAndroidInjector(modules = [LoginIdPassFragmentModule::class])
    abstract fun provideLoginIdPassFragment(): LoginIdPassFragment
}