package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImage(
        var small: String? = null,
        var medium: String? = null,
        var large: String? = null
) : Parcelable