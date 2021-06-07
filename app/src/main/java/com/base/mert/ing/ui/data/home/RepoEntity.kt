package com.base.mert.ing.ui.data.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepoEntity(
        val id: Int?,
        val name: String?
): Parcelable