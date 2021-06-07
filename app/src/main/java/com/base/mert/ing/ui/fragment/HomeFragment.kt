package com.base.mert.ing.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.base.mert.ing.R
import com.base.mert.ing.adapter.RepoAdapter
import com.base.mert.ing.core.base.BaseFragment
import com.base.mert.ing.databinding.FragmentHomeBinding
import com.base.mert.ing.vm.HomeFragmentViewModel

class HomeFragment: BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(HomeFragmentViewModel::class.java),
SwipeRefreshLayout.OnRefreshListener{

    /**
     * Repo Adapter
     */
    val repoAdapter: RepoAdapter by lazy {
        RepoAdapter(vm.cachedList)
    }

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: HomeFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentHomeBinding) {
        binding.viewModel = vm
        vm.onRefresh()
        bindAdapter()
        bindViews()

        vm.apply {
            responseLiveData.observeForever {
                it?.let {
                    repoAdapter.notifyDataSetChanged()
                }
            }
            progress.observeForever {
                if (it) {
                    binding.layoutRefresh.isRefreshing = it
                    bd.pb.visibility = View.VISIBLE
                } else {
                    binding.layoutRefresh.isRefreshing = false
                    bd.pb.visibility = View.GONE
                }
            }
        }
    }

    /**
     * Bind Views
     */
    private fun bindViews() = bd.apply {
        layoutRefresh.setOnRefreshListener(this@HomeFragment)
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

    override fun onRefresh() {
        vm.onRefresh()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home

}