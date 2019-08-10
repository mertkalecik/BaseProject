package com.base.mert.baseproject.vm

import android.app.Application
import com.base.mert.baseproject.core.base.BaseViewModel
import com.base.mert.baseproject.custom.ActionLiveData
import javax.inject.Inject

class LoginIdPassViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val clickItemActionLiveData = ActionLiveData<String>()

    fun onButtonClicked() {
        clickItemActionLiveData.sendAction("Run Bitch :)")
    }
}