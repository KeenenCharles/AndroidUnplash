package com.kc.unsplash.api

import okhttp3.OkHttpClient
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

}