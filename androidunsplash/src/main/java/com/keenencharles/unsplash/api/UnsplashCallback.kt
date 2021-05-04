package com.keenencharles.unsplash.api

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnsplashCallback<T>(private var onComplete: (T) -> Unit, private var  onError: (String) -> Unit) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        when (response.code()) {
            in 200..299 -> {
                onComplete(response.body()!!)
            }
            in 400..500 -> {
                val res = response.errorBody()?.string()?.trim()
                val error = Gson().fromJson(res, ErrorResponse2::class.java)
                onError(error.description ?: "An error occurred")
            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onError(t.message?: "Error")
    }
}