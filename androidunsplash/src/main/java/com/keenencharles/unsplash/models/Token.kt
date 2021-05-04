package com.keenencharles.unsplash.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Token(
        var scope: String,
        @SerializedName("access_token") var accessToken: String,
        @SerializedName("token_type") var tokenType: String,
        @SerializedName("created_at") var createdAt: Int
) : Parcelable