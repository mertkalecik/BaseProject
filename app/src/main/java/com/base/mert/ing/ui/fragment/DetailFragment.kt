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
        bundle.getParcelable<RepoEntity>(KEY_REPO)?.let {
            vm.entityLiveData.value = it
            getMainActivity()?.let { activity ->
                if (activity.vm.favoriteList.contains(it.id)) {
                    context?.let {
                        bd.ivStar.background = ContextCompat.getDrawable(it, R.drawable.star_onpressed)
                    }
                }
            }
        }
    }

    override fun configureViewModel(viewModel: DetailFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentDetailBinding) {
        binding.viewModel = vm
        binding.ivStar.setOnClickListener {
            context?.let {
                bd.ivStar.background = ContextCompat.getDrawable(it, R.drawable.star_onpressed)
            }
            getMainActivity()?.let {
                it.vm.apply {
                    vm.entityLiveData.value?.id?.let { id ->
                        if (favoriteList.contains(id)) return@apply
                        favoriteList.add(id)
                    }
                }
            }
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_detail

}