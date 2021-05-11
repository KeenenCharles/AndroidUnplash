package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exif(
        var make: String? = null,
        var model: String? = null,
        var aperture: String? = null,
        var iso: Int? = null,
        @SerializedName("exposure_time") var exposureTime: String? = null,
        @SerializedName("focal_length") var focalLength: String? = null
) : Parcelable