package com.base.mert.ing.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.base.mert.ing.core.base.BaseViewModel
import com.base.mert.ing.custom.ActionLiveData
import com.base.mert.ing.mapper.toRepoEntity
import com.base.mert.ing.ui.data.home.DataSource
import com.base.mert.ing.ui.data.home.Person
import com.base.mert.ing.ui.data.home.RepoEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(
        application: Application
): BaseViewModel(application) {

    companion object {
        const val DELAY = 5L
    }
    val responseLiveData = ActionLiveData<List<RepoEntity>>()
    val cachedList: MutableList<RepoEntity> = mutableListOf()
    val disposable = CompositeDisposable()
    val progress = MutableLiveData<Boolean>()
    val dataSource by lazy { DataSource() }
    var query:String? = null
    var isAllowed = true

    fun onRefresh() {
        if (isAllowed) getPersonList() else progress.postValue(false)
        isAllowed = false
        disposable.add(
                Observable.timer(DELAY, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnError {  }
                        .subscribe {
                            isAllowed = true
                        }
        )
    }

    private fun getPersonList() {
        progress.postValue(true)
        dataSource.fetch(query) { response, error ->
            response?.let {
                query = it.next
                unionList(it.people)
            }
            error?.let {
                progress.postValue(false)
                Log.i("Mert","Error ${it.errorDescription}")
            }
        }
    }

    private fun unionList(pagedList: List<Person>) {
        val list = pagedList.map { it.toRepoEntity() }
        cachedList.orEmpty().toMutableList().also { unifiedList ->
            list.forEach { entity ->
                unifiedList.firstOrNull {
                    it.id == entity.id
                }?.let { Unit } ?: cachedList.add(entity)
            }
        }
        progress.postValue(false)
        responseLiveData.sendAction(cachedList)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}