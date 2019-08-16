package com.kc.unsplash.api

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor(private val clientId: String, private val token: String?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var auth = "Client-ID $clientId"
        if (token != null) {
            auth += ",Bearer $token"
        }
        var request = chain.request()
        request = request.newBuilder()
                .addHeader("Authorization", auth)
                .build()
        return chain.proceed(request)
    }
}