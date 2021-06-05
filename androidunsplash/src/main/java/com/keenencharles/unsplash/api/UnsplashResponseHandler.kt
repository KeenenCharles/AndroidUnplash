package com.keenencharles.unsplash.api

import com.google.gson.Gson
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

class UnsplashResponseHandler {

    fun <T : Any> handleSuccess(data: T? = null): UnsplashResource.Success<T> {
        return UnsplashResource.Success(data)
    }

    fun <T : Any> handleException(e: Exception): UnsplashResource.Error<T> {
        return when (e) {
            is ConnectException -> {
                UnsplashResource.Error("Connection Error")
            }
            is HttpException -> {
                val res = e.response()?.errorBody()?.string()?.trim()
                val error = Gson().fromJson(res, ErrorResponse::class.java)
                val message = error.description ?: "An error occurred"
                UnsplashResource.Error(message)
            }
            is SocketTimeoutException -> {
                UnsplashResource.Error("Timeout")
            }
            else -> {
                UnsplashResource.Error("Unknown Error")
            }
        }
    }

}