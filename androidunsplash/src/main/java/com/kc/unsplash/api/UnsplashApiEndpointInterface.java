package com.kc.unsplash.api;

import com.kc.unsplash.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashApiEndpointInterface {

    @GET("photos/{id}")
    Call<Photo> getPhoto(@Path("id") String id, @Query("w") Integer width, @Query("h") Integer height);

    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("page") int page, @Query("per_page") int perPage,
                                @Query("order_by") String orderBy);

    @GET("photos/curated")
    Call<List<Photo>> getCuratedPhotos(@Query("page") int page, @Query("per_page") int perPage,
                                       @Query("order_by") String orderBy);

    @GET("photos/random")
    Call<Photo> getRandomPhoto(@Query("collections") String collections,
                               @Query("featured") boolean featured, @Query("username") String username,
                               @Query("query") String query, @Query("w") int width,
                               @Query("h") int height, @Query("orientation") String orientation);

    @GET("photos/random")
    Call<List<Photo>> getRandomPhotos(@Query("collections") String collections,
                               @Query("featured") boolean featured, @Query("username") String username,
                               @Query("query") String query, @Query("w") int width,
                               @Query("h") int height, @Query("orientation") String orientation,
                               @Query("count") int count);

    @GET("photos/{id}/download")
    Call<String> getPhotoDownloadLink(@Path("id") String id);

    @GET("search/photos")
    Call<List<Photo>> searchPhotos(@Query("query") String query, @Query("page") int page, @Query("per_page") int perPage);
}
