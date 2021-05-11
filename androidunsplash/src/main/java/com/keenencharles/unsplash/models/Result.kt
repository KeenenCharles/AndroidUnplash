package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
        var id: String? = null,
        var width: Int? = null,
        var height: Int? = null,
        var color: String? = null,
        var likes: Int? = null,
        var user: User? = null,
        var urls: Urls? = null,
        var links: Links? = null,
        val categories: List<Category>? = null,
        @SerializedName("current_user_collections") var currentUserCollections: List<Collection>? = null,
        @SerializedName("liked_by_user") var likedByUser: Boolean? = null,
        @SerializedName("created_at") var createdAt: String? = null,
        @SerializedName("updated_at") var updatedAt: String? = null
) : Parcelable