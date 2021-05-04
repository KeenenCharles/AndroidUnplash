package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
        @SerializedName("total_photos") var totalPhotos: Int? = null,
        @SerializedName("photo_downloads") var photoDownloads: Int? = null
) : Parcelable