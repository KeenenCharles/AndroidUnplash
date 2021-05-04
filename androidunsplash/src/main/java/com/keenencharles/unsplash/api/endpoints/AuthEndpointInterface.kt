package com.keenencharles.unsplash.api.endpoints

import com.keenencharles.unsplash.models.Token
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface AuthEndpointInterface {

    @POST
    fun getToken(@Url url: String,
                 @Query("client_id") clientID: String,
                 @Query("client_secret") clientSecret: String,
                 @Query("redirect_uri") redirectURI: String,
                 @Query("code") code: String,
                 @Query("grant_type") grantType: String): Call<Token>
}
