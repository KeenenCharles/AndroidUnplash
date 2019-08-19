package com.kc.unsplash.api.endpoints

import com.kc.unsplash.models.*
import com.kc.unsplash.models.Collection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserEndpointInterface {

    @GET("me")
    fun getCurrentUser(): Call<User>

    @PUT("me")
    fun updateCurrentUser(user: User): Call<User>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<User>

    @GET("users/{username}/portfolio")
    fun getUserPortfolio(@Path("username") username: String): Call<Portfolio>

    @GET("users/{username}/photos")
    fun getUserPhotos(@Path("username") username: String,
                      @Query("page") page: Int?,
                      @Query("per_page") perPage: Int?,
                      @Query("order_by") orderBy: String,
                      @Query("stats") stats: Boolean?,
                      @Query("resolution") resolution: String?,
                      @Query("quantity") quantity: Int?): Call<List<Photo>>

    @GET("users/{username}/likes")
    fun getUserLikedPhotos(@Path("username") username: String,
                          @Query("page") page: Int?,
                          @Query("per_page") perPage: Int?,
                          @Query("order_by") orderBy: String): Call<List<Photo>>

    @GET("users/{username}/collections")
    fun getUserCollections(@Path("username") username: String,
                      @Query("page") page: Int?,
                      @Query("per_page") perPage: Int?,
                      @Query("order_by") orderBy: String,
                      @Query("stats") stats: Boolean?,
                      @Query("resolution") resolution: String?,
                      @Query("quantity") quantity: Int?):Call<List<Collection>>

    @GET("users/{username}/statistics")
    fun getUserStatistics(@Path("username") username: String,
                           @Query("resolution") resolution: String?,
                           @Query("quantity") quantity: Int?): Call<Stats>

    @GET("search/users")
    fun searchUsers(@Query("query") query: String,
                     @Query("page") page: Int,
                     @Query("per_page") perPage: Int): Call<SearchResults<User>>
}
