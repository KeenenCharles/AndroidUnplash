package com.kc.unsplash.api.endpoints

import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.Collection
import com.kc.unsplash.models.SearchResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsEndpointInterface {

    @GET("collections")
    fun getCollections(@Query("page") page: Int?,
                       @Query("per_page") perPage: Int?): Call<List<Collection>>

    @GET("collections/featured")
    fun getFeaturedCollections(@Query("page") page: Int?,
                               @Query("per_page") perPage: Int?): Call<List<Collection>>

    @GET("collections/curated")
    fun getCuratedCollections(@Query("page") page: Int?,
                              @Query("per_page") perPage: Int?): Call<List<Collection>>

    @GET("collections/{id}")
    fun getCollection(@Path("id") id: String): Call<Collection>

    @GET("collections/curated/{id}")
    fun getCuratedCollection(@Path("id") id: String): Call<Collection>

    @GET("collections/{id}/photos")
    fun getCollectionPhotos(@Path("id") id: String,
                            @Query("page") page: Int?,
                            @Query("per_page") perPage: Int?): Call<List<Photo>>

    @GET("collections/curated/{id}/photos")
    fun getCuratedCollectionPhotos(@Path("id") id: String,
                                   @Query("page") page: Int?,
                                   @Query("per_page") perPage: Int?): Call<List<Photo>>

    @GET("collections/{id}/related")
    fun getRelatedCollections(@Path("id") id: String): Call<List<Collection>>

    @GET("search/collections")
    fun searchCollections(@Query("query") query: String,
                     @Query("page") page: Int,
                     @Query("per_page") perPage: Int): Call<SearchResults<Collection>>
}
