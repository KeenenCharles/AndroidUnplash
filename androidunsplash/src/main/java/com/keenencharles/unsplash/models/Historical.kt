package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Historical(
        var change: Int? = null,
        var average: Int? = null,
        var resolution: String? = null,
        var quantity: Int? = null,
        var values: List<Value>? = null
) : Parcelable