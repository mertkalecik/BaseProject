package com.base.mert.ing.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.base.mert.ing.R
import com.base.mert.ing.core.base.BaseFragment
import com.base.mert.ing.databinding.FragmentLoginIdPassBinding
import com.base.mert.ing.ui.activity.MainActivity
import com.base.mert.ing.vm.LoginIdPassViewModel

class LoginIdPassFragment: BaseFragment<LoginIdPassViewModel, FragmentLoginIdPassBinding>(LoginIdPassViewModel::class.java) {


    override fun readBundle(bundle: Bundle) {

    }

    override fun configureDataBinding(binding: FragmentLoginIdPassBinding) {
        binding.button1.setOnClickListener(View.OnClickListener {
            vm.onButtonClicked()
        })
    }

    override fun configureViewModel(viewModel: LoginIdPassViewModel) {
        vm.clickItemActionLiveData.observeForever {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_login_id_pass

}