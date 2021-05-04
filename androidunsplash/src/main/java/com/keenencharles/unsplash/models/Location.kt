package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
        var city: String? = null,
        var country: String? = null,
        var position: Position? = null
) : Parcelable