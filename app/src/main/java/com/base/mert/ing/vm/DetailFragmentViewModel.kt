package com.base.mert.ing.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.base.mert.ing.core.base.BaseViewModel
import com.base.mert.ing.ui.data.home.RepoEntity
import javax.inject.Inject

class DetailFragmentViewModel @Inject constructor(application: Application): BaseViewModel(application) {
    val entityLiveData = MutableLiveData<RepoEntity>()
}