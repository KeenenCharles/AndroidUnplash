package com.keenencharles.unsplash.api

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
     val error: String,
     @SerializedName("error_description") val description: String?
)