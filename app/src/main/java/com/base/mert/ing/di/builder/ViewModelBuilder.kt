package com.base.mert.ing.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.base.mert.ing.annotations.ViewModelKey
import com.base.mert.ing.di.factory.ViewModelFactory
import com.base.mert.ing.vm.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(LoginIdPassViewModel::class)
        abstract fun provideLoginIdPassViewModel(loginIdPassViewModel: LoginIdPassViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(HomeFragmentViewModel::class)
        abstract fun provideHomeFragmentViewMoel(homeFragmentViewModel: HomeFragmentViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(DetailFragmentViewModel::class)
        abstract fun provideDetailFragmentViewModel(detailFragmentViewModel: DetailFragmentViewModel): ViewModel
}