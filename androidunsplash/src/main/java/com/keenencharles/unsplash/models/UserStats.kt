package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserStats(
        var username: String? = null,
        var downloads: UserStat? = null,
        var views: UserStat? = null,
        var likes: UserStat? = null
) : Parcelable