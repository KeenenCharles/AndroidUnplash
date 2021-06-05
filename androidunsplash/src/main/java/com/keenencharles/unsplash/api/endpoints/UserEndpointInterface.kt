package com.keenencharles.unsplash.api.endpoints

import com.keenencharles.unsplash.models.*
import com.keenencharles.unsplash.models.Collection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserEndpointInterface {

    @GET("me")
    fun getCurrent(): Call<User>

    @GET("me")
    suspend fun getCurrentSuspend(): User

    @PUT("me")
    fun updateCurrent(user: User): Call<User>

    @PUT("me")
    suspend fun updateCurrentSuspend(user: User): User

    @GET("users/{username}")
    fun getByUsername(@Path("username") username: String): Call<User>

    @GET("users/{username}")
    suspend fun getByUsernameSuspend(@Path("username") username: String): User

    @GET("users/{username}/portfolio")
    fun getPortfolio(@Path("username") username: String): Call<Portfolio>

    @GET("users/{username}/portfolio")
    suspend fun getPortfolioSuspend(@Path("username") username: String): Portfolio

    @GET("users/{username}/photos")
    fun getPhotos(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?,
        @Query("stats") stats: Boolean?,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): Call<List<Photo>>

    @GET("users/{username}/photos")
    suspend fun getPhotosSuspend(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?,
        @Query("stats") stats: Boolean?,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): List<Photo>

    @GET("users/{username}/likes")
    fun getLikedPhotos(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): Call<List<Photo>>

    @GET("users/{username}/likes")
    suspend fun getLikedPhotosSuspend(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): List<Photo>

    @GET("users/{username}/collections")
    fun getCollections(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?,
        @Query("stats") stats: Boolean?,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): Call<List<Collection>>

    @GET("users/{username}/collections")
    suspend fun getCollectionsSuspend(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?,
        @Query("stats") stats: Boolean?,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): List<Collection>

    @GET("users/{username}/statistics")
    fun getStatistics(
        @Path("username") username: String,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): Call<Stats>

    @GET("users/{username}/statistics")
    suspend fun getStatisticsSuspend(
        @Path("username") username: String,
        @Query("resolution") resolution: String?,
        @Query("quantity") quantity: Int?
    ): Stats

    @GET("search/users")
    fun search(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): Call<SearchResults<User>>

    @GET("search/users")
    suspend fun searchSuspend(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): SearchResults<User>
}
