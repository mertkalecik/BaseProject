package com.base.mert.ing.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.base.mert.ing.R
import com.base.mert.ing.core.base.BaseFragment
import com.base.mert.ing.core.base.Constants.KEY_REPO
import com.base.mert.ing.databinding.FragmentDetailBinding
import com.base.mert.ing.ui.data.home.RepoEntity
import com.base.mert.ing.vm.DetailFragmentViewModel


class DetailFragment: BaseFragment<DetailFragmentViewModel, FragmentDetailBinding>(DetailFragmentViewModel::class.java) {

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: DetailFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentDetailBinding) {
        binding.viewModel = vm
    }

    override fun getLayoutRes(): Int = R.layout.fragment_detail

}