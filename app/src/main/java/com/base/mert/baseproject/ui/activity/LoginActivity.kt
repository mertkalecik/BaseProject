package com.base.mert.baseproject.ui.activity

import android.app.Activity
import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.base.mert.baseproject.R
import com.base.mert.baseproject.core.base.BaseActivity
import com.base.mert.baseproject.databinding.ActivityLoginBinding
import com.base.mert.baseproject.vm.LoginViewModel
import dagger.android.*
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java) {

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureDataBinding(binding: ActivityLoginBinding) {

    }

    override fun configureViewModel(viewModel: LoginViewModel) {

    }

    override fun getLayoutRes(): Int = R.layout.activity_login

    override fun onSupportNavigateUp() =
            findNavController(this, R.id.my_nav_host_Fragment).navigateUp()

}
