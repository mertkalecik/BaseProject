package com.base.mert.ing.ui.data.home

import com.base.mert.ing.api.GithubApi
import javax.inject.Inject

class GithubRepository @Inject constructor(
        private val service: GithubApi
) {
    fun getRepos(username: String) = service.getRepos(username)
}