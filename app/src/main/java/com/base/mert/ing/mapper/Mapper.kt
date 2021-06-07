package com.base.mert.ing.mapper

import com.base.mert.ing.ui.data.home.Person
import com.base.mert.ing.ui.data.home.RepoEntity

fun Person.toRepoEntity() =
        RepoEntity(id = id, name = "$fullName ($id)")