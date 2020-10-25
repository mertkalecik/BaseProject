package com.base.mert.ing.ui.activity


import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.base.mert.ing.R
import com.base.mert.ing.core.base.BaseActivity
import com.base.mert.ing.databinding.ActivityLoginBinding
import com.base.mert.ing.vm.LoginViewModel

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
