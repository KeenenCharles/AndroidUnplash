package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Value(
        var date: String? = null,
        var value: Int? = null,
) : Parcelable