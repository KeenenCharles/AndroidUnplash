package com.kc.unsplash.api.endpoints

import com.kc.unsplash.models.Token
import retrofit2.Call
import retrofit2.http.GET

interface UserEndpointInterface {

    @get:GET("me")
    val me: Call<Token>
}
