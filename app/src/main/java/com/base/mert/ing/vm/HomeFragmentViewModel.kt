package com.base.mert.ing.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.base.mert.ing.core.base.BaseViewModel
import com.base.mert.ing.custom.ActionLiveData
import com.base.mert.ing.ui.data.home.GithubRepository
import com.base.mert.ing.ui.data.home.RepoEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(
        application: Application,
        val repository: GithubRepository
): BaseViewModel(application) {
    val responseLiveData = ActionLiveData<List<RepoEntity>>()
    val progress = MutableLiveData<Boolean>()
    val adapterList = mutableListOf<RepoEntity>()

    fun getRepos(userName: String) {
        progress.postValue(true)
        repository.getRepos(userName).enqueue(object: Callback<List<RepoEntity>> {
            override fun onFailure(call: Call<List<RepoEntity>>, t: Throwable) {
                progress.postValue(false)
                Log.i("Mert","Network Error")
            }

            override fun onResponse(call: Call<List<RepoEntity>>, response: Response<List<RepoEntity>>) {
                progress.postValue(false)
                response.body()?.let {
                    responseLiveData.sendAction(it)
                } ?: kotlin.run { Log.i("Mert", "Repository list is null") }
            }

        })
    }
}