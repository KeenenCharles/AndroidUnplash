package com.kc.unsplash.api.endpoints;

import com.kc.unsplash.models.Collection;
import com.kc.unsplash.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CollectionsEndpointInterface {

    @GET("collections")
    Call<List<Collection>> getCollections(@Query("page") Integer page, @Query("per_page") Integer perPage);

    @GET("collections/features")
    Call<List<Collection>> getFeaturedCollections(@Query("page") Integer page, @Query("per_page") Integer perPage);

    @GET("collections/curated")
    Call<List<Collection>> getCuratedCollections(@Query("page") Integer page, @Query("per_page") Integer perPage);

    @GET("collections/{id}")
    Call<Collection> getCollection(@Path("id") String id);

    @GET("collections/curated/{id}")
    Call<Collection> getCuratedCollection(@Path("id") String id);

    @GET("collections/{id}/photos")
    Call<List<Photo>> getCollectionPhotos(@Path("id") String id, @Query("page") Integer page, @Query("per_page") Integer perPage);

    @GET("collections/curated/{id}/photos")
    Call<List<Photo>> getCuratedCollectionPhotos(@Path("id") String id, @Query("page") Integer page, @Query("per_page") Integer perPage);

    @GET("collections/{id}/related")
    Call<List<Collection>> getRelatedCollections(@Path("id") String id);

}
