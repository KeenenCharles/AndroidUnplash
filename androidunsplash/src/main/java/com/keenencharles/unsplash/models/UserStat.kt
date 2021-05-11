package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserStat(
        var total: Int? = null,
        var historical: Historical? = null
) : Parcelable