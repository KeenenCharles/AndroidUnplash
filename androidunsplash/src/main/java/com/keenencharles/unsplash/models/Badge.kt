package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Badge(
        var title: String,
        var primary: Boolean,
        var slug: String,
        var link: String
) : Parcelable