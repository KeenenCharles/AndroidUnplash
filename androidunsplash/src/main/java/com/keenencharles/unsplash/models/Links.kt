package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
        var self: String? = null,
        var html: String? = null,
        var photos: String? = null,
        var likes: String? = null,
        var portfolio: String? = null,
        var download: String? = null,
        @SerializedName("download_location") var downloadLocation: String? = null
) : Parcelable