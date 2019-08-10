package com.base.mert.baseproject.ui.fragment

import android.os.Bundle
import com.base.mert.baseproject.R
import com.base.mert.baseproject.core.base.BaseFragment
import com.base.mert.baseproject.databinding.FragmentHomeBinding
import com.base.mert.baseproject.vm.HomeFragmentViewModel

class HomeFragment: BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(HomeFragmentViewModel::class.java) {

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: HomeFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentHomeBinding) {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_home
}