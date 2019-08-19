package com.kc.unsplash.api.endpoints

import com.kc.unsplash.models.Download
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults
import retrofit2.Call
import retrofit2.http.*

interface PhotosEndpointInterface {

    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: String,
                 @Query("w") width: Int?,
                 @Query("h") height: Int?): Call<Photo>

    @GET("photos")
    fun getPhotos(@Query("page") page: Int?,
                  @Query("per_page") perPage: Int?,
                  @Query("order_by") orderBy: String): Call<List<Photo>>

    @GET("photos/curated")
    fun getCuratedPhotos(@Query("page") page: Int?,
                         @Query("per_page") perPage: Int?,
                         @Query("order_by") orderBy: String): Call<List<Photo>>

    @GET("photos/random")
    fun getRandomPhoto(@Query("collections") collections: String?,
                       @Query("featured") featured: Boolean?,
                       @Query("username") username: String?,
                       @Query("query") query: String?,
                       @Query("w") width: Int?,
                       @Query("h") height: Int?,
                       @Query("orientation") orientation: String?): Call<Photo>

    @GET("photos/random")
    fun getRandomPhotos(@Query("collections") collections: String?,
                        @Query("featured") featured: Boolean?,
                        @Query("username") username: String?,
                        @Query("query") query: String?,
                        @Query("w") width: Int?,
                        @Query("h") height: Int?,
                        @Query("orientation") orientation: String?,
                        @Query("count") count: Int?): Call<List<Photo>>

    @GET("photos/{id}/download")
    fun getPhotoDownloadLink(@Path("id") id: String): Call<Download>

    @GET("search/photos")
    fun searchPhotos(@Query("query") query: String,
                     @Query("page") page: Int,
                     @Query("per_page") perPage: Int,
                     @Query("orientation") orientation: String?): Call<SearchResults<Photo>>

    @PUT("photos/{id}")
    fun updatePhoto(@Path("id") id: String,
                    @Query("location[latitude]") latitude: String? = null,
                    @Query("location[longitude]") longitude: String? = null,
                    @Query("location[name]") name: String? = null,
                    @Query("location[city]") city: String? = null,
                    @Query("location[country]") country: String? = null,
                    @Query("location[confidential]") confidential: String? = null,
                    @Query("exif[make]") make: String? = null,
                    @Query("exif[model]") model: String? = null,
                    @Query("exif[exposure_time]") exposureTime: String? = null,
                    @Query("exif[exposure_value]") exposureValue: String? = null,
                    @Query("exif[focal_length]") focalLength: String? = null,
                    @Query("exif[iso_speed_ratings]") iso: String? = null): Call<Photo>

    @PUT("photos/{id}/like")
    fun likePhoto(@Path("id") id: String): Call<Photo>

    @DELETE("photos/{id}/like")
    fun unlikePhoto(@Path("id") id: String): Call<Photo>
}
