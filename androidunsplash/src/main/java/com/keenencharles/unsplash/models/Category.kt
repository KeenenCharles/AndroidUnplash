package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
        var id: Int? = null,
        var title: String? = null,
        var links: Links? = null,
        @SerializedName("photo_count") var photoCount: Int? = null
) : Parcelable