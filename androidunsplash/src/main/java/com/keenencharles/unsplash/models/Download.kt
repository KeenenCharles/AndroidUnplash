package com.keenencharles.unsplash.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Download(
        var url: String? = null,
) : Parcelable