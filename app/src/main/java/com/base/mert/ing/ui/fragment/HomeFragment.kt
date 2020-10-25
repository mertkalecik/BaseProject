package com.base.mert.ing.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.mert.ing.R
import com.base.mert.ing.adapter.RepoAdapter
import com.base.mert.ing.core.base.BaseFragment
import com.base.mert.ing.core.base.Constants.KEY_REPO
import com.base.mert.ing.databinding.FragmentHomeBinding
import com.base.mert.ing.extensions.navigateWithBundle
import com.base.mert.ing.ui.data.home.RepoEntity
import com.base.mert.ing.vm.HomeFragmentViewModel

class HomeFragment: BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(HomeFragmentViewModel::class.java) {

    /**
     * Repo Adapter
     */
    val repoAdapter: RepoAdapter by lazy {
        RepoAdapter(vm.adapterList).apply {
            clickListener = {
                val bundle = bundleOf(
                        KEY_REPO to it
                )
                navigateWithBundle(R.id.action_home_fragment_to_detail_fragment, bundle)
            }
        }
    }

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: HomeFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentHomeBinding) {
        binding.viewModel = vm
        bindAdapter()
        bindViews()
        vm.apply {
            responseLiveData.observeForever {
                it?.let {
                    checkStarredRepository(it)
                }
            }
            progress.observeForever {
                if (it) {
                    bd.pb.visibility = View.VISIBLE
                } else {
                    bd.pb.visibility = View.GONE
                }
            }
        }
    }

    /**
     * Check Starred Repos
     */
    fun checkStarredRepository(list: List<RepoEntity>) {
        getMainActivity()?.vm?.favoriteList?.let { favList ->
            favList.forEach { fav ->
                list.forEach { entity ->
                    if (fav == entity.id) {
                        entity.starVisibility = true
                    }
                }
            }
        }
        vm.apply {
            adapterList.clear()
            adapterList.addAll(list)
            repoAdapter.notifyDataSetChanged()
        }
    }

    /**
     * Bind Views
     */
    private fun bindViews() = bd.apply {
        btnSubmit.setOnClickListener {
            vm.getRepos(etInput.text.toString())
        }
    }

    /**
     * Bind Adapter
     */
    private fun bindAdapter() = bd.rvRepo.apply {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
        )
        adapter = repoAdapter
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home
}