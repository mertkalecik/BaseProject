package com.base.mert.ing.extensions


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.base.mert.ing.di.factory.ViewModelFactory

inline fun <reified T: ViewModel> Fragment.getViewModel(factory: ViewModelFactory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory).get(T::class.java)
    vm.body()
    return vm
}

inline fun <reified T: ViewModel> Fragment.generateExtraViewModel(body: T.() -> Unit): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

fun Fragment.navigateWithBundle(action: Int, bundle: Bundle) =
        findNavController().navigate(action, bundle)

