package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Urls(
        var raw: String? = null,
        var full: String? = null,
        var regular: String? = null,
        var small: String? = null,
        var thumb: String? = null
) : Parcelable