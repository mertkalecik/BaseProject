package com.base.mert.baseproject.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.base.mert.baseproject.di.factory.ViewModelFactory

inline fun <reified T: ViewModel> Fragment.getViewModel(factory: ViewModelFactory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory).get(T::class.java)
    vm.body()
    return vm
}

inline fun <reified T: ViewModel> Fragment.generateExtraViewModel(body: T.() -> Unit): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

