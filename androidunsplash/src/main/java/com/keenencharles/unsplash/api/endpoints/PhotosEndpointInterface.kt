package com.keenencharles.unsplash.api.endpoints

import com.keenencharles.unsplash.models.Download
import com.keenencharles.unsplash.models.Photo
import com.keenencharles.unsplash.models.SearchResults
import retrofit2.Call
import retrofit2.http.*

interface PhotosEndpointInterface {

    @GET("photos/{id}")
    fun getById(@Path("id") id: String): Call<Photo>

    @GET("photos/{id}")
    suspend fun getByIdSuspend(@Path("id") id: String): Photo

    @GET("photos")
    fun get(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): Call<List<Photo>>

    @GET("photos")
    suspend fun getSuspend(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): List<Photo>

    @GET("photos/random")
    fun getRandomPhoto(
        @Query("collections") collections: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") content: String?
    ): Call<Photo>

    @GET("photos/random")
    suspend fun getRandomPhotoSuspend(
        @Query("collections") collections: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") content: String?
    ): Photo

    @GET("photos/random")
    fun getRandomPhotos(
        @Query("collections") collections: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("count") count: Int?,
        @Query("content_filter") content: String?
    ): Call<List<Photo>>

    @GET("photos/random")
    suspend fun getRandomPhotosSuspend(
        @Query("collections") collections: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("count") count: Int?,
        @Query("content_filter") content: String?
    ): List<Photo>

    @GET("photos/{id}/download")
    fun getDownloadLink(@Path("id") id: String): Call<Download>

    @GET("photos/{id}/download")
    suspend fun getDownloadLinkSuspend(@Path("id") id: String): Download

    @GET("search/photos")
    fun search(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("collections") collections: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") content: String?,
        @Query("color") color: String?
    ): Call<SearchResults<Photo>>

    @GET("search/photos")
    suspend fun searchSuspend(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("collections") collections: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") content: String?,
        @Query("color") color: String?
    ): SearchResults<Photo>

    @PUT("photos/{id}")
    fun update(
        @Path("id") id: String,
        @Query("location[latitude]") latitude: String?,
        @Query("location[longitude]") longitude: String?,
        @Query("location[name]") name: String?,
        @Query("location[city]") city: String?,
        @Query("location[country]") country: String?,
        @Query("location[confidential]") confidential: String?,
        @Query("exif[make]") make: String?,
        @Query("exif[model]") model: String?,
        @Query("exif[exposure_time]") exposureTime: String?,
        @Query("exif[exposure_value]") exposureValue: String?,
        @Query("exif[focal_length]") focalLength: String?,
        @Query("exif[iso_speed_ratings]") iso: String?
    ): Call<Photo>

    @PUT("photos/{id}")
    suspend fun updateSuspend(
        @Path("id") id: String,
        @Query("location[latitude]") latitude: String?,
        @Query("location[longitude]") longitude: String?,
        @Query("location[name]") name: String?,
        @Query("location[city]") city: String?,
        @Query("location[country]") country: String?,
        @Query("location[confidential]") confidential: String?,
        @Query("exif[make]") make: String?,
        @Query("exif[model]") model: String?,
        @Query("exif[exposure_time]") exposureTime: String?,
        @Query("exif[exposure_value]") exposureValue: String?,
        @Query("exif[focal_length]") focalLength: String?,
        @Query("exif[iso_speed_ratings]") iso: String?
    ): Photo

    @PUT("photos/{id}/like")
    fun like(@Path("id") id: String): Call<Photo>

    @PUT("photos/{id}/like")
    suspend fun likeSuspend(@Path("id") id: String): Photo

    @DELETE("photos/{id}/like")
    fun unlike(@Path("id") id: String): Call<Photo>

    @DELETE("photos/{id}/like")
    suspend fun unlikeSuspend(@Path("id") id: String): Photo
}
