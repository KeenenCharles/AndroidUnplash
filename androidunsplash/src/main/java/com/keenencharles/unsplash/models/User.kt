package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        var id: String? = null,
        var username: String? = null,
        var name: String? = null,
        var bio: String? = null,
        var location: String? = null,
        var totalLikes: Int? = null,
        var downloads: Int? = null,
        var badge: Badge? = null,
        var links: Links? = null,
        @SerializedName("current_user_collections") var currentUserCollections: List<CurrentUserCollection>? = null,
        @SerializedName("profile_image") var profileImage: ProfileImage? = null,
        @SerializedName("total_photos") var totalPhotos: Int? = null,
        @SerializedName("total_collections") var totalCollections: Int? = null,
        @SerializedName("followed_by_user") var followedByUser: Boolean? = null,
        @SerializedName("followers_count") var followersCount: Int? = null,
        @SerializedName("first_name") var firstName: String? = null,
        @SerializedName("last_name") var lastName: String? = null,
        @SerializedName("instagram_username") var instagramUsername: String? = null,
        @SerializedName("twitter_username") var twitterUsername: String? = null,
        @SerializedName("portfolio_url") var portfolioUrl: String? = null,
        @SerializedName("updated_at") var updatedAt: String? = null
) : Parcelable