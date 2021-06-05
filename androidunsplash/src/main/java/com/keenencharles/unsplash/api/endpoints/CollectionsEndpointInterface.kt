package com.keenencharles.unsplash.api.endpoints

import com.keenencharles.unsplash.models.Photo
import com.keenencharles.unsplash.models.Collection
import com.keenencharles.unsplash.models.SearchResults
import retrofit2.Call
import retrofit2.http.*

interface CollectionsEndpointInterface {

    @GET("collections")
    fun get(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): Call<List<Collection>>

    @GET("collections")
    suspend fun getSuspend(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): List<Collection>

    @GET("collections/{id}")
    fun getById(@Path("id") id: String): Call<Collection>

    @GET("collections/{id}")
    suspend fun getByIdSuspend(@Path("id") id: String): Collection

    @GET("collections/{id}/photos")
    fun getPhotos(
        @Path("id") id: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): Call<List<Photo>>

    @GET("collections/{id}/photos")
    suspend fun getPhotosSuspend(
        @Path("id") id: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): List<Photo>

    @GET("collections/{id}/related")
    fun getRelated(@Path("id") id: String): Call<List<Collection>>

    @GET("collections/{id}/related")
    suspend fun getRelatedSuspend(@Path("id") id: String): List<Collection>

    @GET("search/collections")
    fun search(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): Call<SearchResults<Collection>>

    @GET("search/collections")
    suspend fun searchSuspend(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): SearchResults<Collection>

    @POST("collections")
    fun create(
        @Query("title") query: String,
        @Query("description") page: String?,
        @Query("private") private: Boolean?
    ): Call<Collection>

    @POST("collections")
    suspend fun createSuspend(
        @Query("title") query: String,
        @Query("description") page: String?,
        @Query("private") private: Boolean?
    ): Collection

    @PUT("collections/{id}")
    fun update(
        @Path("id") id: String,
        @Query("title") query: String?,
        @Query("description") page: String?,
        @Query("private") private: Boolean?
    ): Call<Collection>

    @PUT("collections/{id}")
    suspend fun updateSuspend(
        @Path("id") id: String,
        @Query("title") query: String?,
        @Query("description") page: String?,
        @Query("private") private: Boolean?
    ): Collection

    @DELETE("collections/{id}")
    fun delete(@Path("id") id: String): Call<Collection>

    @DELETE("collections/{id}")
    suspend fun deleteSuspend(@Path("id") id: String): Collection

    @POST("collections/{id}/add")
    fun addPhoto(
        @Query("collection_id") collectionId: String,
        @Query("photo_id") page: String?
    ): Call<Collection>

    @POST("collections/{id}/add")
    suspend fun addPhotoSuspend(
        @Query("collection_id") collectionId: String,
        @Query("photo_id") page: String?
    ): Collection

    @DELETE("collections/{id}/add")
    fun removePhoto(
        @Query("collection_id") collectionId: String,
        @Query("photo_id") page: String?
    ): Call<Collection>

    @DELETE("collections/{id}/add")
    suspend fun removePhotoSuspend(
        @Query("collection_id") collectionId: String,
        @Query("photo_id") page: String?
    ): Collection
}
