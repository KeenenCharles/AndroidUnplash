package com.kc.unsplash.api

import android.util.Log
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnsplashCallback<T>(private var onComplete: (T) -> Unit,private var  onError: (String) -> Unit) : Callback<T> {

    private val TAG = "AndroidUnsplash"

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val statusCode = response.code()
        if (statusCode in 200..299) {
            onComplete(response.body()!!)
        }
        else if (statusCode == 401) {
            Log.d(TAG, "Unauthorized: Check your Client ID")
        }
        else if (statusCode in 400..500) {
            val errors = (response.body() as JsonElement).asJsonObject.getAsJsonArray("errors")
            Log.d(TAG, errors.toString())
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onError(t.message?: "Error")
    }
}