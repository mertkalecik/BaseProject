package com.base.mert.ing.di.provider

import com.base.mert.ing.di.module.LoginIdPassFragmentModule
import com.base.mert.ing.ui.fragment.LoginIdPassFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginIdPassFragmentProvider {

    @ContributesAndroidInjector(modules = [LoginIdPassFragmentModule::class])
    abstract fun provideLoginIdPassFragment(): LoginIdPassFragment
}