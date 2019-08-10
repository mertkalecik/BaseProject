package com.base.mert.baseproject.core.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.mert.baseproject.di.factory.ViewModelFactory
import com.base.mert.baseproject.extensions.getViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject



abstract class BaseFragment<VM: BaseViewModel, DB: ViewDataBinding>(private val viewModelClazz: Class<VM>): Fragment(), LifecycleOwner {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var vm: VM
    lateinit var bd: DB

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        bd = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        vm = ViewModelProviders.of(this, viewModelFactory).get(viewModelClazz)

        savedInstanceState?.let {
            readBundle(it)
        }

        configureViewModel(vm)

        return bd.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureDataBinding(bd)
    }

    abstract fun configureViewModel(viewModel: VM)
    abstract fun configureDataBinding(binding: DB)
    abstract fun readBundle(bundle: Bundle)

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState ==null
}