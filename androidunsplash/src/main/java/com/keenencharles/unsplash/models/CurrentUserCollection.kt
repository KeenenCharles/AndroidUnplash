package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentUserCollection(
        var id: Int? = null,
        var title: String? = null,
        var curated: Boolean? = null,
        @SerializedName("user") var user: User? = null,
        @SerializedName("cover_photo") var coverPhoto: CoverPhoto? = null,
        @SerializedName("published_at") var publishedAt: String? = null,
        @SerializedName("updated_at") var updatedAt: String? = null,
) : Parcelable