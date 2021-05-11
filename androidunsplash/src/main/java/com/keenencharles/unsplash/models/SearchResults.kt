package com.keenencharles.unsplash.models

import com.google.gson.annotations.SerializedName

data class SearchResults<T>(
        var total: Int? = null,
        var results: List<T> = listOf(),
        @SerializedName("total_pages") var totalPages: Int? = null
)