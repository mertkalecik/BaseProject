package com.base.mert.baseproject.ui.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.base.mert.baseproject.R
import com.base.mert.baseproject.core.base.BaseActivity
import com.base.mert.baseproject.databinding.ActivityMainBinding
import com.base.mert.baseproject.extensions.setupWithNavController
import com.base.mert.baseproject.vm.MainActivityViewModel

class MainActivity: BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {

    lateinit var currentNavController : LiveData<NavController>
    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: MainActivityViewModel) {

    }

    override fun configureDataBinding(binding: ActivityMainBinding) {
        initToolbar()
        setupBottomNavigationBar()
    }


    fun initToolbar() {
        supportActionBar!!.title = " "
        bd.bottomNavigation.selectedItemId = 2131361910 as Int
        bd.bottomNavigation.itemIconTintList = null
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
                R.navigation.nav_home,
                R.navigation.nav_map,
                R.navigation.nav_person
        )
        
        val controller = bd.bottomNavigation.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.my_nav_host_Fragment,
                intent = intent
        )

        controller.observe(this, Observer { navController->
            val appBarConf = AppBarConfiguration.Builder(navController!!.graph)
                    //.setDrawerLayout(bd.drawerLayout)
                    .build()
            NavigationUI.setupWithNavController(bd.toolbar, navController, appBarConf)
        })

        currentNavController = controller
    }

    override fun getLayoutRes(): Int = R.layout.activity_main
}


