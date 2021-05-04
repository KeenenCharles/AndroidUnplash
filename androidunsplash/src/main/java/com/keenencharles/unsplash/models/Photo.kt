package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Photo(
        var id: String? = null,
        var width: Int? = null,
        var height: Int? = null,
        var color: String? = null,
        var downloads: Int? = null,
        var likes: Int? = null,
        var exif: Exif? = null,
        var location: Location? = null,
        var urls: Urls? = null,
        var links: Links? = null,
        var user: User? = null,
        var categories: List<Category> = ArrayList(),
        @SerializedName("current_user_collections") var currentUserCollections: List<Collection> = ArrayList(),
        @SerializedName("liked_by_user") var likedByUser: Boolean? = null,
        @SerializedName("created_at") var createdAt: String? = null,
        @SerializedName("updated_at") var updatedAt: String? = null
) : Parcelable