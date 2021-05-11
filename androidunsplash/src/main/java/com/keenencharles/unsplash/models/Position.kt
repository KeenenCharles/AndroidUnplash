package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Position(
        var latitude: Double? = null,
        var longitude: Double? = null
) : Parcelable