package com.base.mert.ing.vm

import android.app.Application
import com.base.mert.ing.core.base.BaseViewModel
import com.base.mert.ing.custom.ActionLiveData
import javax.inject.Inject

class LoginIdPassViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    val clickItemActionLiveData = ActionLiveData<String>()

    fun onButtonClicked() {
        clickItemActionLiveData.sendAction("Run Bitch :)")
    }
}