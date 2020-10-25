package com.base.mert.ing.vm

import android.app.Application
import com.base.mert.ing.core.base.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(application: Application): BaseViewModel(application) {
    val favoriteList = mutableListOf<Int>()
}