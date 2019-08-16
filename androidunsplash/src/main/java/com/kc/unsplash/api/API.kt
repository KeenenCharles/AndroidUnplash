package com.kc.unsplash.api

import android.util.Log
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API(clientId: String, token: String?) {

    private val TAG = "AndroidUnsplash"

    var retrofit: Retrofit

    init {
        val builder = Retrofit.Builder()
        val headerInterceptor = HeaderInterceptor(clientId, token)

        val client = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor).build()

        retrofit = builder
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    abstract inner class UnsplashCallback<T> : Callback<T> {

        internal abstract fun onComplete(response: T?)

        internal abstract fun onError(call: Call<T>, message: String)

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val statusCode = response.code()
            if (statusCode == 200) {
                onComplete(response.body())
            } else if (statusCode >= 400) {
                onError(call, statusCode.toString())

                if (statusCode == 401) {
                    Log.d(TAG, "Unauthorized, Check your client Id")
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(call, t.message!!)
        }
    }
}