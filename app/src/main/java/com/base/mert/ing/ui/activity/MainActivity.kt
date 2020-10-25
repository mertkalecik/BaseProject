package com.base.mert.ing.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.base.mert.ing.R
import com.base.mert.ing.core.base.BaseActivity
import com.base.mert.ing.databinding.ActivityMainBinding
import com.base.mert.ing.vm.MainActivityViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.view.*
import setupWithNavController

class MainActivity: BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java), NavigationView.OnNavigationItemSelectedListener {

    lateinit var currentNavController : LiveData<NavController>

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureViewModel(viewModel: MainActivityViewModel) {

    }

    override fun configureDataBinding(binding: ActivityMainBinding) {
        initToolbar()
        setupBottomNavigationBar()
        val toggle = ActionBarDrawerToggle(
                this,
                bd.drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        bd.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (bd.drawerLayout.isDrawerOpen(GravityCompat.START))
            bd.drawerLayout.closeDrawer(GravityCompat.START)
        else
            currentNavController.value?.navigateUp()
    }


    fun initToolbar() {
        supportActionBar!!.title = " "
        bd.bottomNavigation.selectedItemId = R.id.home
        bd.bottomNavigation.itemIconTintList = null
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
                R.navigation.nav_home
        )
        
        val controller = bd.bottomNavigation.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.nav_Fragment,
                intent = intent
        )

        controller.observe(this, Observer { navController->
            val appBarConf = AppBarConfiguration.Builder(navController!!.graph)
                    .setDrawerLayout(bd.drawerLayout)
                    .build()

            NavigationUI.setupWithNavController(bd.toolbar.toolbar, navController, appBarConf)
        })

        currentNavController = controller
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onNavigationItemSelected(p0: MenuItem): Boolean = true
}


