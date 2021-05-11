package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collection(
        var id: Int? = null,
        var title: String? = null,
        var description: String? = null,
        var curated: Boolean? = null,
        var private: Boolean? = null,
        var user: User? = null,
        var links: Links? = null,
        @SerializedName("cover_photo") var coverPhoto: CoverPhoto? = null,
        @SerializedName("share_key") var shareKey: String? = null,
        @SerializedName("total_photos") var totalPhotos: Int? = null,
        @SerializedName("published_at") var publishedAt: String? = null,
        @SerializedName("updated_at") var updatedAt: String? = null
) : Parcelable