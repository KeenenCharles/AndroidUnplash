package com.kc.unsplash;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kc.unsplash.models.Photo;
import com.kc.unsplash.api.HeaderInterceptor;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.api.UnsplashApiEndpointInterface;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Unsplash {

    public static final String BASE_URL = "https://api.unsplash.com/";

    private String clientId;
    private UnsplashApiEndpointInterface apiService;

    public Unsplash(String clientId) {
        this.clientId = clientId;

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor(clientId)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(UnsplashApiEndpointInterface.class);
    }

    public void getPhotos(Integer page, Integer perPage, Order order, final OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.getPhotos(page, perPage, order.getOrder());
        call.enqueue(getMultiplePhotoCallback(listener));
    }

    public void getCuratedPhotos(Integer page, Integer perPage, Order order, final OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.getCuratedPhotos(page, perPage, order.getOrder());
        call.enqueue(getMultiplePhotoCallback(listener));
    }

    public void getPhoto(@NonNull String id, final OnPhotoLoadedListener listener){
        getPhoto(id, null, null, listener);
    }

    public void getRandomPhoto(@Nullable String collections,
                               @Nullable Boolean featured, @Nullable String username,
                               @Nullable String query, @Nullable Integer width,
                               @Nullable Integer height, @Nullable String orientation, OnPhotoLoadedListener listener){
        Call<Photo> call = apiService.getRandomPhoto(collections, featured, username, query, width, height, orientation);
        call.enqueue(getSinglePhotoCallback(listener));
    }

    public void getRandomPhotos(@Nullable String collections,
                                @Nullable Boolean featured, @Nullable String username,
                                @Nullable String query, @Nullable Integer width,
                                @Nullable Integer height, @Nullable String orientation,
                                @Nullable Integer count, OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.getRandomPhotos(collections, featured, username, query, width, height, orientation, count);
        call.enqueue(getMultiplePhotoCallback(listener));
    }

    public void searchPhotos(@NonNull String query, @Nullable Integer page, @Nullable Integer perPage, OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.searchPhotos(query, page, perPage);
        call.enqueue(getMultiplePhotoCallback(listener));
    }

    public void getPhotoDownloadLink(@NonNull String id, final OnLinkLoadedListener listener){
        Call<String> call = apiService.getPhotoDownloadLink(id);
        call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    int statusCode = response.code();
                    if(statusCode == 200) {
                        listener.onComplete(response.body());
                    }
                    else if(statusCode == 401) {
                        Log.d("Unsplash", "Unauthorized, Check your client Id");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    listener.onError(t.getMessage());
                }
            }
        );
    }

    public void getPhoto(@NonNull String id, @Nullable Integer width, @Nullable Integer height, final OnPhotoLoadedListener listener){
        Call<Photo> call = apiService.getPhoto(id, width, height);
        call.enqueue(getSinglePhotoCallback(listener));
    }

    private Callback<Photo> getSinglePhotoCallback(final OnPhotoLoadedListener listener){
        return new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                int statusCode = response.code();
                if(statusCode == 200) {
                    Photo photo = response.body();
                    listener.onComplete(photo);
                }
                else if(statusCode == 401) {
                    Log.d("Unsplash", "Unauthorized, Check your client Id");
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        };
    }

    private Callback<List<Photo>> getMultiplePhotoCallback(final OnPhotosLoadedListener listener){
        return new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                int statusCode = response.code();
                if(statusCode == 200) {
                    List<Photo> photos = response.body();
                    listener.onComplete(photos);
                }
                else if(statusCode == 401) {
                    Log.d("Unsplash", "Unauthorized, Check your client Id");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        };
    }

    public interface OnPhotosLoadedListener {
        public void onComplete(List<Photo> photos);

        public void onError(String error);
    }

    public interface OnPhotoLoadedListener {
        public void onComplete(Photo photo);

        public void onError(String error);
    }

    public interface OnLinkLoadedListener {

        public void onComplete(String downloadLink);

        public void onError(String error);
    }

}
