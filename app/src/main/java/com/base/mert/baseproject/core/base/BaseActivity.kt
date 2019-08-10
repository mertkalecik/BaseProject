package com.base.mert.baseproject.core.base

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.base.mert.baseproject.R
import com.base.mert.baseproject.di.factory.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_login.view.*
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel, DB: ViewDataBinding>(private val viewModelClazz: Class<VM>): AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val bd by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    val vm by lazy {
        ViewModelProviders.of(this, factory).get(viewModelClazz)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        intent.extras?.let {
            readBundle(intent.extras)
        }

        configureViewModel(vm)
        configureDataBinding(bd)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(getLayoutRes())
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null)
            setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Login")
    }


    abstract fun configureViewModel(viewModel: VM)
    abstract fun configureDataBinding(binding: DB)
    abstract fun readBundle(bundle: Bundle)

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> = fragmentInjector
}