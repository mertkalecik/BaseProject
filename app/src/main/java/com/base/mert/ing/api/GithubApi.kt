package com.base.mert.ing.api

import com.base.mert.ing.ui.data.home.RepoEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<RepoEntity>>
}